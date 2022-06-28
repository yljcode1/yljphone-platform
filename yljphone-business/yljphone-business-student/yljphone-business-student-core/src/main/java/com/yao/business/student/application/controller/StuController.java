package com.yao.business.student.application.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 学生业务控制层
 *
 * @date: 2022/6/26
 * @author: yao
 */
@RestController
@RequestMapping("/stu")
@RefreshScope
@Slf4j
public class StuController {

    @Value("${spring.datasource.url}")
    private String dbUrl;

    /**
     * 查询所有学生
     */
    @RequestMapping("/list")
    public String list() {
        System.out.println("学生列表:");
        System.out.println(dbUrl);
        log.info("测试打印日志信息");
        return "stu list";
    }
}
