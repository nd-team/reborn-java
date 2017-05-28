package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.to.UserRegisterTO;

/**
 * 注册业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-11 16:38]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserRegisterAPI {

     default  void register(UserRegisterTO registerTO) throws SerException{

     }
}
