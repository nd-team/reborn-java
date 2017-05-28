package com.bjike.reborn.storage.action.storage;

import com.bjike.reborn.common.api.exception.ActException;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.restful.Result;
import com.bjike.reborn.common.consumer.interceptor.login.LoginAuth;
import com.bjike.reborn.common.consumer.restful.ActResult;
import com.bjike.reborn.common.utils.bean.BeanTransform;
import com.bjike.reborn.storage.api.StorageUserAPI;
import com.bjike.reborn.storage.bo.StorageUserBO;
import com.bjike.reborn.storage.to.StorageUserTO;
import com.bjike.reborn.storage.vo.StorageUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 存储模块用户
 *
 * @Author: [ liguiqin ]
 * @Date: [ 2017-03-30 09:39 ]
 * @Description: [ 存储模块用户 ]
 * @Version: [ v1.0.0 ]
 * @Copy: [ com.bjike ]
 */
@RestController
public class StorageUserAct {

    @Autowired
    private StorageUserAPI storageUserAPI;

    /**
     * 注册
     *
     * @param storageUserTO 存储用户传输对象
     * @version v1
     */
    @LoginAuth
    @PostMapping("v1/register")
    public Result register(@Validated(StorageUserTO.REGISTER.class) StorageUserTO storageUserTO, BindingResult result, HttpServletRequest request) throws ActException {
        try {
            String token = request.getHeader("userToken");
            if (null != token) {
                storageUserTO.setUserToken(token);
                StorageUserBO storageUserBO = storageUserAPI.register(storageUserTO);
                return ActResult.initialize(BeanTransform.copyProperties(storageUserBO, StorageUserVO.class));
            } else {
                throw new ActException("请先登录用户!");
            }

        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 登录
     *
     * @param storageUserTO 存储用户传输对象
     * @version v1
     */
    @PostMapping("v1/login")
    public Result login(@Validated(StorageUserTO.LOGIN.class) StorageUserTO storageUserTO, BindingResult result) throws ActException {
        try {
            String token = storageUserAPI.login(storageUserTO);
            return ActResult.initialize(token);
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

    /**
     * 退出
     *
     * @param token 登录存储用户storageToken
     * @version v1
     */
    @PostMapping("v1/sign-out/{token}")
    public Result signOut(@RequestParam String token) throws ActException {
        try {
            Boolean result = storageUserAPI.signOut(token);
            return ActResult.initialize(result);
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

}