package com.xiongtian.common.Result;

import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.annotation.*;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/10 16:26
 * * @description: TODO 规范响应数据的注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
@Documented
@ResponseBody
public @interface ResponseDataBody {
}
