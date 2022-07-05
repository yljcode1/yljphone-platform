package com.yao.business.student.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;

/**
 * date: 2022/6/26
 * author: yao
 * 学生服务启动类
 * @author yao
 */
@SpringBootApplication
@MapperScan("com.yao.data.mapper")
public class StuApplication {
    public static void main(String[] args) {
        SpringApplication.run(StuApplication.class, args);
    }
}
