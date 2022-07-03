package com.yao.commons.web.exception;

import com.yao.commons.web.resp.Response;
import com.yao.commons.web.resp.ResponseCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 统一异常处理
 *
 * @date: 2022/7/3
 * @author: yao
 */
@Slf4j
@RestControllerAdvice
public class GlobalException {


    /**
     * 统一异常全局处理
     *
     * @param t 异常
     * @return 响应结果
     */
    @ExceptionHandler(Throwable.class)
    public Response exceptionHandler(Throwable t) {
        log.error("[Global-Exception] -捕获到全局异常", t);
        return Response.fail(ResponseCode.FAIL);
    }
}
