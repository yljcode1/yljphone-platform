package com.yao.commons.web.resp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Set;

/**
 * 统一接口返回对象
 *
 * @date: 2022/7/3
 * @author: yao
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> implements Serializable {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应信息
     */
    private String message;
    /**
     * 返回数据
     */
    private T data;

    /**
     * 生成指定相应成功枚举类
     *
     * @param data 传入数据
     * @param <T>  返回类型
     * @return 返回对象
     */
    public static <T> Response<T> success(T data) {
        return new Response(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMsg(), data);
    }

    /**
     * 生成指定相应失败枚举类
     *
     * @param data 传入数据
     * @param <T>  返回类型
     * @return 返回对象
     */
    public static <T> Response<T> fail(T data) {
        return new Response(ResponseCode.FAIL.getCode(), ResponseCode.FAIL.getMsg(), data);
    }

    /**
     * 生成指定相应枚举类
     *
     * @param code code对象
     * @param data 传入数据
     * @param <T>  返回类型
     * @return 返回对象
     */
    public static <T> Response<T> create(ResponseCode code, T data) {
        return new Response(code.getCode(), code.getMsg(), data);
    }

    /**
     * 生成指定相应枚举类
     *
     * @param code code对象
     * @param <T>  返回类型
     * @return 返回对象
     */
    public static <T> Response<T> fail(ResponseCode code) {
        return new Response(code.getCode(), code.getMsg(), null);
    }

    public static <T> Response fail(ResponseCode paramentError, T data) {
        return new Response(paramentError.getCode(), paramentError.getMsg(), data);
    }
}
