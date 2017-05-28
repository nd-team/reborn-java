package com.bjike.reborn.user.action.user;

import com.bjike.reborn.common.api.exception.ActException;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.restful.Result;
import com.bjike.reborn.common.consumer.restful.ActResult;
import com.bjike.reborn.user.api.UserFindPwdAPI;
import com.bjike.reborn.user.bo.UserSimpleBO;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 找回密码
 *
 * @Author: [liguiqin]
 * @Date: [2017-01-14 15:47]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@DefaultProperties
@RestController
@RequestMapping("pwd")
public class FindPwdAct {

    @Autowired
    private UserFindPwdAPI userFindPwdAPI;

    /**
     * 验证码验证
     *
     * @param account  账号email,username,phone
     * @param authCode 验证码
     * @version v1
     */
    @GetMapping("v1/verify{account}/{authCode}")
    public Result verifyAccount(@RequestParam String account, @RequestParam String authCode) throws ActException {
        try {
            UserSimpleBO simpleBO = userFindPwdAPI.verifyAccount(account, authCode);
            return ActResult.initialize(simpleBO);
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }


}