package com.xiongtian.common.Result;

import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.annotation.Annotation;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/10 16:27
 */
@RestControllerAdvice(basePackages = "com.xiongtian")
public class ResponseDataBodyAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 拿到自定义的注解
     */
    private static final Class<? extends Annotation> ANNOTATION_TYPE = ResponseDataBody.class;

    /**
     * 判断类或者方法是否使用了 @ResponseDataBody
     * 这里将注解添加在BaseController上面；以为着只要继承了BaseController的Controller都使用了该注解
     * @param returnType
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> aClass) {
        return AnnotatedElementUtils.hasAnnotation(returnType.getContainingClass(), ANNOTATION_TYPE) || returnType.hasMethodAnnotation(ANNOTATION_TYPE);
    }


    /**
     * 当类或者方法使用了 @ResponseDataBody 也就是上面的方法返回的true 就会调用这个方法
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        // 防止重复包裹的问题出现 如果已经是要返回的基础对象了 就直接返回
        if (body instanceof BaseResponseDto) {
            return body;
        }
        // 否则的话就直接返回
        return ReturnUtils.success(body);
    }
}
