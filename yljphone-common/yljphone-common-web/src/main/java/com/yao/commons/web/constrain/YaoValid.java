package com.yao.commons.web.constrain;

import com.yao.commons.web.annotation.CustomValid;

/**
 * 架构层校验实现接口
 *
 * @param <T>
 */
public interface YaoValid<T> {
    boolean isValid(CustomValid customValid, T value);
}
