package com.yao.commons.web.config;

import com.yao.commons.web.exception.GlobalException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @date: 2022/7/3
 * @author: yao
 */
@Configuration
public class BaseConfiguration {
    /**
     * 装配全局异常处理类
     *
     * @return 全局异常处理类
     */
    @Bean
    public GlobalException getGlobalException() {
        return new GlobalException();
    }
}
