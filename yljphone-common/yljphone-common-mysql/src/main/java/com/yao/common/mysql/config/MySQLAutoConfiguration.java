package com.yao.common.mysql.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * mysql的自动装配
 *
 * @date: 2022/7/5
 * @author: yao
 */
@Configuration
@MapperScan("com.yao.data.mapper")
@EnableTransactionManagement
public class MySQLAutoConfiguration {
}
