package com.bjike.reborn.user.service;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.session.auth_code.AuthCodeSession;
import com.bjike.reborn.user.session.valid_err.PwdErrSession;
import org.springframework.stereotype.Service;

/**
 * 用户验证码业务实现
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-26 09:36]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service
public class UserAuthCodeSerImpl implements UserAuthCodeSer {

    @Override
    public Boolean showAuthCode(String account) throws SerException {

        int count = PwdErrSession.get(account);
        return count >= 5;  //验证次数大于5次需要验证码
    }


    /**
     * 保存验证码到session
     *
     * @param account
     * @param code
     */
    public void handleAuthCode(String account, String code) throws SerException {
        AuthCodeSession.put(account, code);
    }

}
