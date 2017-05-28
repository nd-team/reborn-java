package com.bjike.reborn.user.action.key;

import com.bjike.reborn.common.api.exception.ActException;
import com.bjike.reborn.common.api.exception.SerException;
import com.bjike.reborn.common.api.restful.Result;
import com.bjike.reborn.common.consumer.restful.ActResult;
import com.bjike.reborn.user.api.UserAPI;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 密码公钥
 *
 * @Author: [liguiqin]
 * @Date: [2017-04-13 15:10]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@DefaultProperties
@RestController
@RequestMapping("public")
public class PublicKeyAct {
    @Autowired
    private UserAPI userAPI;

    /**
     * 获取公钥
     *
     * @version v1
     */
    @GetMapping("v1/key")
    public Result key() throws ActException  {

        try {
            return ActResult.initialize(userAPI.publicKey());
        } catch (SerException e) {
            throw new ActException(e.getMessage());
        }
    }

}
