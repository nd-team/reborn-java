package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.annotation.Operate;
import com.bjike.reborn.user.to.UserLoginTO;

/**
 * 对外提供用户登录业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2017-03-11 15:24]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserLoginAPI {


    /**
     * 登录
     *
     * @param loginTO 用户登陆数据传输对象
     * @return token 登录用户唯一令牌
     * @throws SerException
     */
    String login(UserLoginTO loginTO) throws SerException;

    /**
     * 注销登陆
     *
     * @param token 登录用户唯一令牌
     * @return
     * @throws SerException
     */
    Boolean signOut(String token) throws SerException;

}
