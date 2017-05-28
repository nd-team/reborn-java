package com.bjike.reborn.user.service;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.session.auth_code.AuthCodeSession;
import com.bjike.reborn.user.bo.UserBO;
import com.bjike.reborn.user.bo.UserSimpleBO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户找回密码业务实现
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-30 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class UserFindPwdSerImpl implements UserFindPwdSer {
    @Autowired
    private UserSer userSer;

    @Override
    public UserSimpleBO verifyAccount(String account, String authCode) throws SerException {
        UserBO userBO = null;//userSer.findByAccountNumber(account);
        if (null == userBO) {
            throw new SerException("用户不存在");
        }
        String code = AuthCodeSession.get(account);
        if (null == code && !code.equalsIgnoreCase(authCode)) {
            throw new SerException("验证码不正确");
        }

        return new UserSimpleBO();
    }

}
