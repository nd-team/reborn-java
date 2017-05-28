package com.bjike.reborn.user.service;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.to.UserRegisterTO;

/**
 * 用户注册业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserRegisterSer {
    default void register(UserRegisterTO registerTO) throws SerException {

    }

}
