package com.yao.business.student.application.controller;

import com.yao.business.student.input.StudentInput;
import com.yao.commons.web.resp.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public Response<String> list() {
        System.out.println("学生列表:");
        System.out.println(dbUrl);
        log.info("测试打印日志信息");
//        System.out.println(1 / 0);
        return Response.success("stu list");
    }

    /**
     * 登录用户
     */
    @RequestMapping("/login")
    public Response<String> login(String username, String password) {
        log.info("[stu-login]学生登录，用户名:{},密码:{}", username, password);
        return Response.success("登录成功");
    }

    @PostMapping("/insert")
    public Response<String> insert(@Valid StudentInput stu) {
        log.info("[stu-insert] 学生添加.{}", stu);
        // 后续调用业务层
        return Response.success("添加学生成功");
    }
}
