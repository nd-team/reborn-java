package com.bjike.reborn.user.service.rbac;


import com.bjike.reborn.common.api.dto.Restrict;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.type.Status;
import com.bjike.reborn.common.jpa.service.ServiceImpl;
import com.bjike.reborn.user.bo.rbac.UserRoleBO;
import com.bjike.reborn.user.dto.UserDTO;
import com.bjike.reborn.user.dto.rbac.RoleDTO;
import com.bjike.reborn.user.dto.rbac.UserRoleDTO;
import com.bjike.reborn.user.entity.User;
import com.bjike.reborn.user.entity.rbac.Role;
import com.bjike.reborn.user.entity.rbac.UserRole;
import com.bjike.reborn.user.service.UserSer;
import com.bjike.reborn.user.to.rbac.UserRoleTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色业务实现
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */

@CacheConfig(cacheNames = "userSerCache")
@Service
public class UserRoleSerImpl extends ServiceImpl<UserRole, UserRoleDTO> implements UserRoleSer {

    @Autowired
    private UserSer userSer;
    @Autowired
    private RoleSer roleSer;

    @Cacheable
    @Override
    public List<UserRole> findByUserId(String userId) throws SerException {
        UserRoleDTO dto = new UserRoleDTO();
        dto.getConditions().add(Restrict.eq("user.id", userId));
        dto.getConditions().add(Restrict.eq("role.status", Status.THAW));
        return findByCis(dto);
    }

    @Override
    public UserRoleBO saveByTO(UserRoleTO userRoleTO) throws SerException {
        String userId = userRoleTO.getUserId();
        String roleId = userRoleTO.getRoleId();
        UserRoleDTO dto = new UserRoleDTO();
        dto.getConditions().add(Restrict.eq("user.id", userId));
        dto.getConditions().add(Restrict.eq("role.id", roleId));
        if (null == super.findOne(dto)) {
            UserDTO userDTO = new UserDTO();
            userDTO.getConditions().add(Restrict.eq("id", userId));
            User user = userSer.findOne(userDTO);
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.getConditions().add(Restrict.eq("id", roleId));
            Role role = roleSer.findOne(roleDTO);
            if (null == user) {
                throw new SerException("用户不存在!");
            }
            if (null == role) {
                throw new SerException("角色不存在!");
            }
            UserRole userRole = new UserRole();
            userRole.setUser(user);
            userRole.setRole(role);
            super.save(userRole);
            UserRoleBO userRoleBO = new UserRoleBO();
            userRoleBO.setId(userRole.getId());
            userRoleBO.setRoleId(role.getId());
            userRoleBO.setUserId(user.getId());
            return userRoleBO;
        } else {
            throw new SerException("用户角色已存在!");
        }


    }
}
