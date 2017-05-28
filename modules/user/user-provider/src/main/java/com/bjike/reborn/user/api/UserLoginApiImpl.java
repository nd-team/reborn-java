package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.service.UserLoginSer;
import com.bjike.reborn.user.to.UserLoginTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-11 15:23]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service("userLoginApiImpl")
public class UserLoginApiImpl implements UserLoginAPI {
    @Autowired
    private UserLoginSer userLoginSer;

    @Override
    public String login(UserLoginTO loginTO) throws SerException {
        return userLoginSer.login(loginTO);
    }

    @Override
    public Boolean signOut(String token) throws SerException {
        return userLoginSer.signOut(token);
    }
}
