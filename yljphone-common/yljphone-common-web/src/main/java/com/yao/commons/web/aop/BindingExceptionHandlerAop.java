package com.yao.commons.web.aop;

import com.yao.commons.web.annotation.BindingExceptionHandlers;
import com.yao.commons.web.resp.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @date: 2022/7/4
 * @author: yao
 */
@Component
public class BindingExceptionHandlerAop {
    @Around("@annotation(com.yao.commons.web.annotation.BindingExceptionHandlers)")
    public Response bindException(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed = joinPoint.proceed();

        // 获取注解
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        BindingExceptionHandlers annotation = method.getAnnotation(BindingExceptionHandlers.class);
        Class<? extends Throwable>[] classes = annotation.value();
        for (Class<? extends Throwable> aClass : classes) {
            for (Method declaredMethod : aClass.getDeclaredMethods()) {
                declaredMethod.getParameterTypes();
            }
        }
        return null;
    }
}
