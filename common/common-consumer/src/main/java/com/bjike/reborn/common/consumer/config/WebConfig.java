package com.bjike.reborn.common.consumer.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.bjike.reborn.common.consumer.interceptor.ErrorRequestInterceptor;
import com.bjike.reborn.common.consumer.interceptor.idem.IdempotencyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 拦截器配置
 *
 * @Author: [liguiqin]
 * @Date: [2017-01-15 10:10]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Component
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired(required = false)
    private Interceptor interceptor;
    @Autowired(required = false)
    private IdempotencyInterceptor idempotencyFilter;

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter4 fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter4();
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(mediaTypes);
        converters.add(fastJsonHttpMessageConverter);
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        if (null != idempotencyFilter) {
            registry.addInterceptor(idempotencyFilter).excludePathPatterns(idempotencyFilter.getExcludePathPatterns()).addPathPatterns(idempotencyFilter.getPathPatterns());//幂等请求
        }
        registry.addInterceptor(new ErrorRequestInterceptor()).addPathPatterns("/**");

        if (null != interceptor && interceptor.customerInterceptors() != null) {
            for (HIInfo h : interceptor.customerInterceptors()) {
                registry.addInterceptor(h.getHandlerInterceptor()).addPathPatterns(h.getPath());
            }
        }

        super.addInterceptors(registry);
    }

}
