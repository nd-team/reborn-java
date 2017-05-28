package com.bjike.reborn.user.api.rbac;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.rbac.UserRoleBO;
import com.bjike.reborn.user.to.rbac.UserRoleTO;

/**
 * 对外提供用户角色业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2017-04-13 13:54]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserRoleAPI {
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
