package com.yao.commons.web.resp;

import lombok.Getter;

/**
 * 接口返回响应码枚举类
 */
@Getter
public enum ResponseCode {
    SUCCESS(200, "成功"),

    FAIL(500, "服务器异常"),

    PARAMENT_ERROR(501, "参数校验异常");

    private Integer code;
    private String msg;

    ResponseCode(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    ResponseCode() {
    }
}
