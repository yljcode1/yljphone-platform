package com.yao.common.core.config.listener;

import org.slf4j.MDC;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.event.GenericApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.ResolvableType;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

/**
 * 监听SpringBoot的环境参数准备好的事件
 *
 * @date: 2022/6/30
 * @author: yao
 */
public class LogMDCListener implements GenericApplicationListener {
    private static final String APPLICATION_CONFIG_PROPERTIES = "configurationProperties";
    private static final String APP_NAME = "spring.application.name";

    /**
     * 监听的事件类型，如果返回true，则调用onApplicationEvent方法，进行事件处理
     * <p>
     * 需要处理 ApplicationEnvironmentPrepareEvent 类型
     *
     * @param eventType 事件类型
     * @return 是不是我想要处理的事件类型
     */
    @Override
    public boolean supportsEventType(ResolvableType eventType) {
        return ApplicationEnvironmentPreparedEvent.class == eventType.getRawClass();
    }

    /**
     * 处理某个事件
     *
     * @param event 事件
     */
    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // 将事件类型强制转换
        ApplicationEnvironmentPreparedEvent environmentPreparedEvent = (ApplicationEnvironmentPreparedEvent) event;
        // 获取到当前应用参数环境
        ConfigurableEnvironment environment = environmentPreparedEvent.getEnvironment();
        // 获取到参数源列表
        MutablePropertySources propertySources = environment.getPropertySources();
//        propertySources.stream().forEach(propertySource -> {
//            System.out.println("数据源:" + propertySource);
//        });
        // 获取固定名称参数数据源 -configurationProperties
        PropertySource<?> propertySource = propertySources.get(APPLICATION_CONFIG_PROPERTIES);
        String appName = (String) propertySource.getProperty(APP_NAME);
        System.out.println("微服务名称:" + appName);
        MDC.put("logName", appName);
        MDC.put("logPath", appName);

    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 19;
    }
}
