package com.yao.commons.web.constrain;

import com.yao.commons.web.annotation.CustomValid;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 自定义校验处理器
 *
 * @date: 2022/7/4
 * @author: yao
 */
@Slf4j
public class CustomValidHandler implements ConstraintValidator<CustomValid, String> {
    /**
     * 核心的校验方法
     *
     * @param s
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        // 执行校验逻辑，返回true表示校验通过，返回false表示校验未通过
        log.info("开始校验属性");

        return true;
    }
}
