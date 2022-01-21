package com.xiongtian.aspect;

import com.xiongtian.common.IdempotentConstant;
import com.xiongtian.utils.IdempotentUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author xiongtian
 * @version 1.0
 * @date 2021/12/7 14:37
 * @see :防止重复操作切面（处理切面注解）
 */

@Aspect
@Component
public class PreventDuplicationAspect {


    /**
     * 定义切点
     */
    @Pointcut("@annotation(com.xiongtian.annotation.PreventDuplication)")
    public void preventDuplication() {
    }

    @Around("preventDuplication()")
    public Object before(ProceedingJoinPoint joinPoint) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        Assert.notNull(request, "request cannot be null.");

        // 获取执行方法
        // Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();

        // 获取防重复提交注解
        //PreventDuplication annotation = method.getAnnotation(PreventDuplication.class);

        // 获取token以及方法标记，生成redisKey和redisValue
        String token = request.getHeader(IdempotentConstant.TOKEN);

        boolean judge = IdempotentUtils.judge(token, this.getClass());
        if (!judge) {
            throw new RuntimeException("请勿重复提交！");
        }
        // 正常执行方法并返回
        // ProceedingJoinPoint 类型参数可以决定是否执行目标方法，且环绕通知必须要有返回值，返回值即为目标方法的返回值
        try {
            return joinPoint.proceed();
        } catch (Throwable throwable) {
            throw new RuntimeException(throwable);
        }

    }
}
