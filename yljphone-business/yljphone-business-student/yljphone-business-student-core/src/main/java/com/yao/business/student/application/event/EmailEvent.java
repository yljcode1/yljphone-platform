package com.yao.business.student.application.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 自定义监听事件
 *
 * @date: 2022/8/8
 * @author: yao
 */
public class EmailEvent extends ApplicationEvent {

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public EmailEvent(Object source) {
        super(source);
    }
}
