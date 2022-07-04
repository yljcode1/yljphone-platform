package com.yao.commons.web.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义校验注解
 */
@Documented
@Target({ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//自定义校验注解必须标记的注解，方法validateBy 用于指定实际的校验过程的类
@Constraint(validatedBy = Xxx.class)
public @interface CustomValid {
    /**
     * 校验失败后的提示信息
     */
    String message() default "校验未通过";

    /**
     * 设置校验的分组信息
     */
    Class<?>[] groups() default {};

    /**
     * 设置校验的负载-元数据
     */
    Class<? extends Payload>[] payload() default {};
}
