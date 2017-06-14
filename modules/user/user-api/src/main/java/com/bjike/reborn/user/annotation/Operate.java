package com.bjike.reborn.user.annotation;

import java.lang.annotation.*;

/**
 * @Author: [liguiqin]
 * @Date: [2017-05-28 16:11]
 * @Description: [ ]
 * @Version: [1.0.0]
 * @Copy: [com.bjike]
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Operate {
    String method() default "";
    String name() default "";
}
