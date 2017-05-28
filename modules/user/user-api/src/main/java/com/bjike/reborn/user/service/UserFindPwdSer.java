package com.bjike.reborn.user.service;


import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.UserSimpleBO;

/**
 * 用户找回密码接口
 *
 * @Author: [liguiqin]
 * @Date: [2016-11-23 15:47]
 * @Description: ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserFindPwdSer {


    /**
     * 是否存在该用户 并验证验证码是否正确
     *
     * @param account  用户
     * @param authCode 验证码
     * @return
     * @throws SerException
     */
    UserSimpleBO verifyAccount(String account, String authCode) throws SerException;



}
