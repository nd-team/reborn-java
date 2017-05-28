package com.bjike.reborn.user.service.rbac;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.service.Ser;
import com.bjike.reborn.user.bo.rbac.RolePermissionBO;
import com.bjike.reborn.user.dto.rbac.RolePermissionDTO;
import com.bjike.reborn.user.entity.rbac.RolePermission;
import com.bjike.reborn.user.to.rbac.RolePermissionTO;

import java.util.List;

/**
 * 角色权限业务
 *
 * @Author: [liguiqin]
 * @Date: [2017-02-28 14:51]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface RolePermissionSer extends Ser<RolePermission, RolePermissionDTO> {
    /**
     * 通过角色id查询其权限资源
     * @param ids 角色id
     * @return
     * @throws SerException
     */
    default List<RolePermission> findByRoleIds(String... ids) throws SerException {
        return null;
    }

    /**
     * 保存角色权限
     *
     * @param rolePermissionTO
     * @return
     * @throws SerException
     */
    default RolePermissionBO saveByTO(RolePermissionTO rolePermissionTO) throws SerException {
        return null;
    }
}
