package com.bjike.reborn.common.consumer.config;

import com.bjike.reborn.common.consumer.interceptor.idem.IdempotencyInterceptor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * @Author: [huanghuanlai]
 * @Date: [2017-01-15 09:59]
 * @Description: []
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Configuration
public class Beans {

//    @Bean
    public IdempotencyInterceptor idempotencyInterceptor(){
        return new IdempotencyInterceptor();
    }

}
