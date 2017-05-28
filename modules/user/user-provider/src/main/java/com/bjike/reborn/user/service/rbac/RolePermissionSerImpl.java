package com.bjike.reborn.user.service.rbac;

import com.bjike.reborn.common.api.dto.Restrict;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.type.Status;
import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.user.bo.rbac.RolePermissionBO;
import com.bjike.reborn.user.dto.rbac.PermissionDTO;
import com.bjike.reborn.user.dto.rbac.RoleDTO;
import com.bjike.reborn.user.dto.rbac.RolePermissionDTO;
import com.bjike.reborn.user.entity.rbac.Permission;
import com.bjike.reborn.user.entity.rbac.Role;
import com.bjike.reborn.user.entity.rbac.RolePermission;
import com.bjike.reborn.user.to.rbac.RolePermissionTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 角色资源业务实现
 *
 * @Author: [liguiqin]
 * @Date: [2017-02-28 14:09]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@CacheConfig(cacheNames = "userSerCache")
@Service
public class RolePermissionSerImpl extends ServiceImpl<RolePermission, RolePermissionDTO> implements RolePermissionSer {

    @Autowired
    private RoleSer roleSer;
    @Autowired
    private PermissionSer permissionSer;

    @Override
    public List<RolePermission> findByRoleIds(String... ids) throws SerException {
        RolePermissionDTO dto = new RolePermissionDTO();
        dto.getConditions().add(Restrict.in("role.id", ids));
        dto.getConditions().add(Restrict.eq("permission.status", Status.THAW));
        List<RolePermission> list = super.findByCis(dto);
        return list;
    }

    @Override
    public RolePermissionBO saveByTO(RolePermissionTO rolePermissionTO) throws SerException {
        String permissionId = rolePermissionTO.getPermissionId();
        String roleId = rolePermissionTO.getRoleId();
        RolePermissionDTO dto = new RolePermissionDTO();
        dto.getConditions().add(Restrict.eq("permission.id", permissionId));
        dto.getConditions().add(Restrict.eq("role.id", roleId));
        if (null == super.findOne(dto)) {
            PermissionDTO permissionDTO = new PermissionDTO();
            permissionDTO.getConditions().add(Restrict.eq("id", permissionId));
            Permission permission = permissionSer.findOne(permissionDTO);
            if (null == permission) {
                throw new SerException("权限信息不存在!");
            }
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.getConditions().add(Restrict.eq("id", roleId));
            Role role = roleSer.findOne(roleDTO);
            if (null == role) {
                throw new SerException("角色信息不存在!");
            }
            RolePermission rolePermission = new RolePermission();
            rolePermission.setPermission(permission);
            rolePermission.setRole(role);
            super.save(rolePermission);
            RolePermissionBO rolePermissionBO = new RolePermissionBO();
            rolePermissionBO.setId(rolePermission.getId());
            rolePermissionBO.setPermissionId(permission.getId());
            rolePermissionBO.setRoleId(role.getId());
            return rolePermissionBO;
        } else {
            throw new SerException("角色权限已存在!");
        }

    }
}
