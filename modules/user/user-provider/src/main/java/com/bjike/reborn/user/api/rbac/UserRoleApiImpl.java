package com.bjike.reborn.user.api.rbac;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.rbac.UserRoleBO;
import com.bjike.reborn.user.entity.rbac.UserRole;
import com.bjike.reborn.user.service.rbac.UserRoleSer;
import com.bjike.reborn.user.to.rbac.UserRoleTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: [liguiqin]
 * @Date: [2017-04-13 16:45]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service("userRoleApiImpl")
public class UserRoleApiImpl implements UserRoleAPI {
    @Autowired
    private UserRoleSer userRoleSer;
    @Override
    public UserRoleBO saveByTO(UserRoleTO userRoleTO) throws SerException {
        return userRoleSer.saveByTO(userRoleTO);
    }
}
