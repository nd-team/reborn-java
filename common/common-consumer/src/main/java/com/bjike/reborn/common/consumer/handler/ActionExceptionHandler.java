package com.bjike.reborn.common.consumer.handler;

import com.bjike.reborn.common.api.exception.ActException;
import com.bjike.reborn.common.consumer.http.ResponseContext;
import com.bjike.reborn.common.consumer.restful.ActResult;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by huanghuanlai on 2017/1/14.
 */
@Component
public class ActionExceptionHandler extends AbstractHandlerExceptionResolver {

    private static final Logger LOGGER = LoggerFactory.getLogger(ActionExceptionHandler.class);
    private static final String JSON_CONTEXT = "text/html;charset=utf-8";
    private static final int SUCCESS_STATUS = 200;
    private static final int EXCEPTION_STATUS = 500;
    private static final int EXCEPTION_CODE = 1;

    @Override
    protected ModelAndView doResolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ActResult actResult = new ActResult();
        httpServletResponse.setContentType(JSON_CONTEXT);
        actResult.setMsg(e.getMessage());
        if (e instanceof ActException || e instanceof HystrixBadRequestException) {
            actResult.setCode(2);
            httpServletResponse.setStatus(SUCCESS_STATUS);
        } else {
            httpServletResponse.setStatus(EXCEPTION_STATUS);
            actResult.setCode(EXCEPTION_CODE);
        }
        if ("expire".equals(e.getMessage())) {
            actResult.setCode(401);
            actResult.setMsg("登录已失效!");
        } else if ("notLogin".equals(e.getMessage())) {
            actResult.setCode(403);
            actResult.setMsg("用户未登录!");
        }
        if (StringUtils.isNotBlank(e.getMessage()) && e.getMessage().startsWith("Forbid consumer")) {
            LOGGER.error(e.getMessage());
            actResult.setMsg("服务调用失败");
        }
        ResponseContext.writeData(actResult);

        return new ModelAndView();
    }
}