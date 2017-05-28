package com.bjike.reborn.user.api.rbac;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.provider.utils.RpcTransmit;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.user.bo.UserBO;
import com.bjike.reborn.user.bo.rbac.PermissionAuthBO;
import com.bjike.reborn.user.bo.rbac.PermissionBO;
import com.bjike.reborn.user.service.UserSer;
import com.bjike.reborn.user.service.rbac.PermissionSer;
import com.bjike.reborn.user.session.valid_right.LoginUser;
import com.bjike.reborn.user.session.valid_right.UserSession;
import com.bjike.reborn.user.to.rbac.PermissionTO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: [liguiqin]
 * @Date: [2017-03-11 14:20]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service("permissionApiImpl")
public class PermissionApiImpl implements PermissionAPI {
    @Autowired
    private PermissionSer permissionSer;
    @Autowired
    private UserSer userSer;

    @Override
    public List<PermissionAuthBO> findByUserId(String userId) throws SerException {
        return permissionSer.findByUserId(userId);
    }

    @Override
    public List<PermissionBO> treeData(String id) throws SerException {
        return permissionSer.treeData(id);
    }

    @Override
    public PermissionBO save(PermissionTO permissionTO) throws SerException {
        return permissionSer.save(permissionTO);
    }

    @Override
    public void remove(String id) throws SerException {
        permissionSer.remove(id);
    }

    @Override
    public void update(PermissionTO permissionTO) throws SerException {
        permissionSer.update(permissionTO);
    }

    @Override
    public List<PermissionAuthBO> currentPermissions() throws SerException {
        List<PermissionAuthBO> permissions = userSer.currentPermissions();
        if (null != permissions && permissions.size() > 0) {
            return permissions;
        } else {
            String token = RpcTransmit.getUserToken();
            if (StringUtils.isNotBlank(token)) {
                UserBO userBO = userSer.currentUser(token);
                permissions = permissionSer.findByUserId(userBO.getId());
                if (null != permissions && permissions.size() > 0) {
                    LoginUser loginUser = BeanTransform.copyProperties(userBO, LoginUser.class);
                    loginUser.setPermissions(permissions);
                    UserSession.put(token, loginUser);
                }
            }
            return permissions;
        }

    }
}
