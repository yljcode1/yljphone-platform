package com.yao.common.mysql.config;

import com.yao.common.mysql.plugin.SQLPlugin;
import com.yao.common.mysql.property.SQLPluginEnableConfigInfo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
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
@EnableConfigurationProperties(SQLPluginEnableConfigInfo.class)
public class MySQLAutoConfiguration {

    @Bean
    @ConditionalOnProperty(name = "yljphone.plugin.sql.enable", havingValue = "true", matchIfMissing = false)
    public SQLPlugin getSQLPlugin() {
        return new SQLPlugin();
    }
}
