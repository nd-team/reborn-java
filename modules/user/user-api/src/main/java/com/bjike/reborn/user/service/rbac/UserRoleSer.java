package com.bjike.reborn.user.service.rbac;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.service.Ser;
import com.bjike.reborn.user.bo.rbac.UserRoleBO;
import com.bjike.reborn.user.dto.rbac.UserRoleDTO;
import com.bjike.reborn.user.entity.rbac.UserRole;
import com.bjike.reborn.user.to.rbac.UserRoleTO;

import java.util.List;

/**
 * 用户角色业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserRoleSer extends Ser<UserRole, UserRoleDTO> {
    /**
     * 通过用户id查询该用户拥有的角色
     *
     * @param userId
     * @return
     * @throws SerException
     */
    List<UserRole> findByUserId(String userId) throws SerException;

    /**
     * 保存用户角色
     *
     * @param userRoleTO
     * @return
     * @throws SerException
     */
    default UserRoleBO saveByTO(UserRoleTO userRoleTO) throws SerException {
        return null;
    }

}
