package com.bjike.reborn.common.consumer.interceptor.idem;

import com.bjike.reborn.common.api.restful.Result;
import com.bjike.reborn.common.consumer.restful.ActResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @Author: [huanghuanlai]
 * @Date: [2017-01-15 09:59]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@RestController
public class IdemAct {

    @Autowired(required = false)
    private IdempotencyInterceptor idempotencyFilter;

    @GetMapping("rtoken")
    public Result idem(HttpServletRequest request, HttpServletResponse response) {
        if (null == idempotencyFilter) {
            ActResult actResult = new ActResult("请联系管理员开启请求幂等功能", null);
            actResult.setCode(1);
            return actResult;
        }
        String uuid = UUID.randomUUID().toString();
        IdempotencyInterceptor.getLoadingCache().put(uuid, new Info());
        return new ActResult(null, uuid);
    }

}
