package com.bjike.reborn.user.api.rbac;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.rbac.RolePermissionBO;
import com.bjike.reborn.user.service.rbac.RolePermissionSer;
import com.bjike.reborn.user.to.rbac.RolePermissionTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: [liguiqin]
 * @Date: [2017-04-13 13:53]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service("rolePermissionApiImpl")
public class RolePermissionApiImpl implements RolePermissionAPI {
    @Autowired
    private RolePermissionSer rolePermissionSer;

    @Override
    public RolePermissionBO saveByTO(RolePermissionTO rolePermissionTO) throws SerException {
        return rolePermissionSer.saveByTO(rolePermissionTO);
    }
}
