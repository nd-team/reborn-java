package com.bjike.reborn.common.consumer.interceptor.login;

import java.lang.annotation.*;

/**
 * 存储登录安全认证
 *
 * @Author: [liguiqin]
 * @Date: [2017-05-10 08:48]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface StorageAuth {
}
