package com.bjike.reborn.common.consumer.interceptor;

import com.bjike.reborn.common.consumer.restful.ActResult;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 错误请求处理
 *
 * @Author: [huanghuanlai]
 * @Date: [2017-01-15 09:59]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Component
public class ErrorRequestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        if (200 != httpServletResponse.getStatus()) {
            ActResult result = new ActResult();
            httpServletResponse.setHeader("Content-Type", "application/json;charset=UTF-8");
            if (httpServletResponse.getStatus() == 404) {
                result.setMsg("访问的请求不存在.");
            } else if (httpServletResponse.getStatus() == 400) {
                result.setMsg("请检查请求参数.");
            } else if (httpServletResponse.getStatus() == 500) {
                result.setMsg(((Exception) o).getMessage());
            } else if (httpServletResponse.getStatus() == 405) {
                result.setMsg("请求方式不支持,请检查.");
            }
            result.setCode(httpServletResponse.getStatus());
            httpServletResponse.getWriter().print(result.toString());
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
