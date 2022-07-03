package com.yao.commons.web.resp;

/**
 * 快捷生成Response对象工具方法
 *
 * @date: 2022/7/3
 * @author: yao
 */
public class ResponseUtils {

    public static <T> Response create(T data) {
        return new Response(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
    }

}
