package com.xiongtian.annotation;

import java.lang.annotation.*;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/7 14:27
 * @see : 防止重复注解操作
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PreventDuplication {

    /**
     * 防重复操作限时标记数值
     * @return
     */
    String value() default  "value";

    /**
     * 防重复操作过期时间
     * @return
     */
    long expireSeconds() default 10;
}
