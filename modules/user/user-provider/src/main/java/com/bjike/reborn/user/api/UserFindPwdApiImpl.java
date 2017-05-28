package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.UserSimpleBO;
import com.bjike.reborn.user.service.UserFindPwdSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: [liguiqin]
 * @Date: [2017-04-17 15:38]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service("userFindPwdApiImpl")
public class UserFindPwdApiImpl implements UserFindPwdAPI {
    @Autowired
    private UserFindPwdSer userFindPwdSer;

    @Override
    public UserSimpleBO verifyAccount(String account, String authCode) throws SerException {
        return userFindPwdSer.verifyAccount(account, authCode);
    }


}
