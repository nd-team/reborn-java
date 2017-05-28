package com.bjike.reborn.user.action.user;

import com.bjike.reborn.common.api.exception.ActException;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.restful.Result;
import com.bjike.reborn.common.consumer.restful.ActResult;
import com.bjike.reborn.user.api.UserRegisterAPI;
import com.bjike.reborn.user.to.UserRegisterTO;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 用户注册
 *
 * @Author: [liguiqin]
 * @Date: [2017-01-14 09:46]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@DefaultProperties
@RestController
public class RegisterAct {
    @Autowired
    private UserRegisterAPI userRegisterAPI;

    /**
     * 注册用户
     *
     * @param registerTO 注册用户信息
     * @throws ActException
     * @version v1
     */
    @PostMapping("v1/register")
    public Result register(@Validated UserRegisterTO registerTO, BindingResult result) throws ActException {
        try {
            userRegisterAPI.register(registerTO);
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
        return new ActResult("注册成功！");
    }


}
