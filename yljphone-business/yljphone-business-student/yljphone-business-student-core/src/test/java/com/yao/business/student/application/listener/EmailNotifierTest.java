package com.yao.business.student.application.listener;

import com.yao.business.student.application.StuApplication;
import com.yao.business.student.application.event.EmailEvent;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StuApplication.class)
class EmailNotifierTest {


    @Test
    void onApplicationEvent() {
        new EmailEvent(new Object());
    }
}