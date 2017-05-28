package com.bjike.reborn.user.api;

import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.user.bo.UserSimpleBO;

/**
 *对外提供找回密码业务接口
 *
 * @Author: [liguiqin]
 * @Date: [2017-04-17 15:36]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
public interface UserFindPwdAPI {


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
