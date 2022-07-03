package com.yao.business.student.application.controller;

import com.yao.business.student.application.StuApplication;
import lombok.extern.slf4j.Slf4j;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = StuApplication.class)
class StuControllerTest {

    @Autowired
    private StuController stuController;


    @Test
    void list() {
        stuController.list();
    }

    @Test
    void login() {
        stuController.login("zhangsan", "lisi");
    }
}