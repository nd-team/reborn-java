package com.bjike.reborn.user.service;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.service.Ser;
import com.bjike.reborn.user.dto.UserDTO;
import com.bjike.reborn.user.entity.User;
import com.bjike.reborn.user.to.UserLoginTO;

/**
 * 用户登陆业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-24 09:37]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserLoginSer extends Ser<User, UserDTO> {


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
