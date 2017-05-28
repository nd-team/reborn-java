package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.UserLoginLogBO;
import com.bjike.reborn.user.service.UserLoginLogSer;
import com.bjike.reborn.user.to.UserLoginLogTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: [liguiqin]
 * @Date: [2017-03-11 17:07]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Service("userLoginLogApiImpl")
public class UserLoginLogApiImpl implements UserLoginLogAPI {
    @Autowired
    private UserLoginLogSer loginLogSer;

    @Override
    public void save(UserLoginLogTO loginLogTO) throws SerException {
        loginLogSer.saveLoginLog(loginLogTO);
    }

    @Override
    public List<UserLoginLogBO> findByUserId(String userId) throws SerException {
        return null;
    }
}
