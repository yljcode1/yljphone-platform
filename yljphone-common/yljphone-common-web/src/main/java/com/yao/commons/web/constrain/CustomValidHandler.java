package com.yao.commons.web.constrain;

import com.yao.commons.web.annotation.CustomValid;
import com.yao.commons.web.utils.ApplicationUtils;
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
public class CustomValidHandler implements ConstraintValidator<CustomValid, Object> {
    private CustomValid customValid;

    @Override
    public void initialize(CustomValid constraintAnnotation) {
        this.customValid = constraintAnnotation;
    }

    /**
     * 核心的校验方法
     *
     * @param s
     * @param constraintValidatorContext
     * @return
     */
    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
        // 执行校验逻辑，返回true表示校验通过，返回false表示校验未通过
//        log.info("开始校验属性");
//        if (s != null) {
//            if (!s.trim().equals("男") || s.trim().equals("女")) {
//                return false;
//            }
//        }
//        return true;
//    }
        if (s != null) {
            // 校验逻辑
            // 获取开发者自定义的处理器类型
            Class<? extends YaoValid> handler = customValid.handler();

            // 通过开发者的类型从容器中获取到Bean对象
            YaoValid yaoValid = ApplicationUtils.getBean(handler);
            if (yaoValid == null) {
                return true;
            }
            return yaoValid.isValid(customValid, s);

        }
        return true;
    }
}
