package com.yao.business.student.application.controller;

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
public class StuController {

    /**
     * 查询所有学生
     */
    @RequestMapping("/list")
    public String list() {
        System.out.println("学生列表:");
        return "stu list";
    }
}
