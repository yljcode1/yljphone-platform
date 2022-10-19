package com.yao.controller;

import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @date: 2022-10-18
 * @author: yao
 */
@RestController
public class TestController {
    @GetMapping("/test")
    public String test1() {
        return "this is a test for dockerfile";
    }
}
