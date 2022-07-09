package com.yao.common.mysql.property;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @date: 2022/7/9
 * @author: yao
 */
@Data
@ConfigurationProperties(prefix = "yljphone.plugin.sql")
public class SQLPluginEnableConfigInfo {
    private boolean enable;
}
