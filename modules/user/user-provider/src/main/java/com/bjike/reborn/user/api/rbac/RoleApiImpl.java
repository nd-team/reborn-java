package com.bjike.reborn.user.api.rbac;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.rbac.RoleBO;
import com.bjike.reborn.user.service.rbac.RoleSer;
import com.bjike.reborn.user.to.rbac.RoleTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-11 14:13]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service("roleApiImpl")
public class RoleApiImpl implements RoleAPI {
    @Autowired
    private RoleSer roleSer;

    @Override
    public List<RoleBO> treeData(String id) throws SerException {
        return roleSer.treeData(id);
    }

    @Override
    public RoleBO save(RoleTO roleTO) throws SerException {
        return roleSer.save(roleTO);
    }

    @Override
    public void remove(String id) throws SerException {
        roleSer.remove(id);
    }

    @Override
    public void update(RoleTO roleTO) throws SerException {
        roleSer.update(roleTO);
    }
}
