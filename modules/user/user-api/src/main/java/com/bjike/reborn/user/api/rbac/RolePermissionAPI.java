package com.bjike.reborn.user.api.rbac;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.rbac.RolePermissionBO;
import com.bjike.reborn.user.to.rbac.RolePermissionTO;

/**
 * 对外提供角色权限业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2017-04-13 14:18]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface RolePermissionAPI {
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
