package com.yao.business.student.application.listener;

import com.yao.business.student.application.event.EmailEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @date: 2022/8/8
 * @author: yao
 */
@Slf4j
public class EmailNotifier implements ApplicationListener<EmailEvent> {

    @Override
    public void onApplicationEvent(EmailEvent event) {
        log.info("EmailEvent类启动了，准备发邮件");
        // TODO 发邮件
        log.info("发邮件");
    }
}
