package com.bjike.reborn.user.service.rbac;


import com.bjike.reborn.common.api.dto.Restrict;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.type.Status;
import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.user.bo.rbac.PermissionAuthBO;
import com.bjike.reborn.user.bo.rbac.PermissionBO;
import com.bjike.reborn.user.dto.rbac.PermissionDTO;
import com.bjike.reborn.user.entity.rbac.Permission;
import com.bjike.reborn.user.entity.rbac.Role;
import com.bjike.reborn.user.entity.rbac.RolePermission;
import com.bjike.reborn.user.service.UserSer;
import com.bjike.reborn.user.to.rbac.PermissionTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 权限认证业务实现
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@CacheConfig(cacheNames = "userSerCache")
@Service
public class PermissionSerImpl extends ServiceImpl<Permission, PermissionDTO> implements PermissionSer {

    @Autowired
    private RolePermissionSer rolePermissionSer;
    @Autowired
    private UserSer userSer;

    @Override
    public List<PermissionAuthBO> findByUserId(String userId) throws SerException {
        String table_permission = super.getTableName(Permission.class);
        String table_role = super.getTableName(Role.class);
        String table_rolePermission = super.getTableName(RolePermission.class);

        StringBuilder sb = new StringBuilder();
        String[] fields = new String[]{"resource", "hasChild"};
        sb.append("  SELECT  DISTINCT a.id,a.name,a.resource,a.is_hasChild as hasChild FROM ");
        sb.append(table_permission);
        sb.append(" a,( ");
//     #角色所有权限id
        sb.append("  SELECT a.permission_id as id FROM  ");
        sb.append(table_rolePermission);
        sb.append(" a WHERE a.role_id IN ");
//    #某用户所有角色
        sb.append(" (SELECT DISTINCT id FROM (SELECT b.id from rbac_user_role a , ");
        sb.append(table_role);
        sb.append("  b WHERE a.role_id = b.id and a.user_id= '");
        sb.append(userId);
        sb.append("'");
        sb.append(")f) )b WHERE a.id=b.id ");
        String sql = sb.toString();
        List<PermissionAuthBO> permissions = super.findBySql(sql, PermissionAuthBO.class, fields);
        return permissions;
    }


    @Override
    public List<PermissionBO> findByRoleId(String roleId) throws SerException {
        List<RolePermission> rolePermissions = rolePermissionSer.findByRoleIds(roleId);
        Set<Permission> permissions = new HashSet<>();
        rolePermissions.stream().forEach(rolePermission -> {
            permissions.add(rolePermission.getPermission());
        });
        return BeanTransform.copyProperties(permissions, PermissionBO.class);
    }

    @Override
    public List<PermissionBO> treeData(String id) throws SerException {
        PermissionDTO dto = new PermissionDTO();
        if (StringUtils.isNotBlank(id)) {
            dto.getConditions().add(Restrict.eq("parent.id", id)); //查询该父节点下的子节点
        } else {
            dto.getConditions().add(Restrict.isNull("parent.id")); //查找根节点
        }
        dto.getConditions().add(Restrict.eq(STATUS, Status.THAW));
        String sysNO = userSer.currentSysNO();
        dto.getConditions().add(Restrict.eq(SYS_NO, sysNO));
        List<Permission> permissions = super.findByCis(dto);


        return BeanTransform.copyProperties(permissions, PermissionBO.class);
    }

    @Transactional
    @Override
    public void remove(String id) throws SerException {

        List<Permission> children = getChild(id);
        if (null != children && children.size() > 0) {
            throw new SerException("该记录存在子节点数据,请先删除子节点!");
        }

        Permission permission = super.findById(id);
        Permission parent = permission.getParent();
        if (null != parent) {
            children = getChild(parent.getId());
            parent.setHasChild(children.size() != 0);
            super.update(parent);
        }
        super.remove(id);
    }

    @Transactional
    @Override
    public PermissionBO save(PermissionTO permissionTO) throws SerException {
        Permission permission = BeanTransform.copyProperties(permissionTO, Permission.class, true);
        if (StringUtils.isNotBlank(permissionTO.getParentId())) {
            PermissionDTO dto = new PermissionDTO();
            dto.getConditions().add(Restrict.eq("id", permissionTO.getParentId()));
            Permission parent = findOne(dto);
            if (null != parent) {
                permission.setParent(parent);
                parent.setHasChild(true); //更新父类子节点字段为true
                super.update(parent);
            }
        }
        permission.setHasChild(false);
        String sysNO = userSer.currentSysNO();
        permission.setSystemNO(sysNO);
        super.save(permission);
        return BeanTransform.copyProperties(permission, PermissionBO.class);
    }

    @Transactional
    @Override
    public void update(PermissionTO permissionTO) throws SerException {
        Permission permission = super.findById(permissionTO.getId());
        Permission old_parent = permission.getParent();
        String parentId = permissionTO.getParentId();
        Permission new_parent = null;
        if (StringUtils.isNotBlank(parentId)) {
            PermissionDTO dto = new PermissionDTO();
            dto.getConditions().add(Restrict.eq("id", permissionTO.getParentId()));
            new_parent = super.findOne(dto);
        }

        //更新
        permission.setModifyTime(LocalDateTime.now());
        permission.setName(permissionTO.getName());
        permission.setResource(permissionTO.getResource());
        permission.setParent(new_parent);
        permission.setModifyTime(LocalDateTime.now());
        super.update(permission);


        if (null != new_parent) {
            new_parent.setHasChild(true);
            super.update(new_parent);
        }

        /**
         * 维护该节点与其父类是否有子节点
         */
        if (null != old_parent) { //以前有父节点,删除父节点后,检查其未更改前的父节点是否还存在子节点
            List<Permission> children = getChild(old_parent.getId()); //查询以未更改前其父类的所有子节点
            old_parent.setHasChild(children.size() != 0);
            super.update(old_parent);
        }


    }

    @Override
    public List<Permission> getChild(String id) throws SerException {
        PermissionDTO dto = new PermissionDTO();
        dto.getConditions().add(Restrict.eq("parent.id", id));
        List<Permission> children = findByCis(dto);
        return children;
    }

}
