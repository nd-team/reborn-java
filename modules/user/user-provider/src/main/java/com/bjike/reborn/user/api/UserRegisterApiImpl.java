package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.service.UserRegisterSer;
import com.bjike.reborn.user.to.UserRegisterTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: [liguiqin]
 * @Date: [2017-03-11 16:40]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service("userRegisterApiImpl")
public class UserRegisterApiImpl implements UserRegisterAPI {
    @Autowired
    private UserRegisterSer userRegisterSer;

    @Override
    public void register(UserRegisterTO registerTO) throws SerException {
        userRegisterSer.register(registerTO);
    }

}
