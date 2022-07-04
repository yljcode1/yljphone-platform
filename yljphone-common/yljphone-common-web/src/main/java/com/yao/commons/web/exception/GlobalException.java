package com.yao.commons.web.exception;

import com.sun.org.apache.xerces.internal.impl.XMLEntityScanner;
import com.yao.commons.web.annotation.BindingExceptionHandlers;
import com.yao.commons.web.resp.Response;
import com.yao.commons.web.resp.ResponseCode;
import com.yao.commons.web.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.MessageCodeFormatter;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.stream.Collectors;

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
        try {
            HttpServletRequest httpServletRequest = RequestUtils.getHttpServletRequest();
            if (httpServletRequest != null) {
                String requestURI = httpServletRequest.getRequestURI();
                log.error("[Global-Exception] -捕获到全局异常,出异常请求-{}", requestURI, t);
            }
        } catch (Exception e) {
            log.error("[Global-Exception] -捕获到全局异常", t);

        }
        // 统一返回结果
        return Response.fail(ResponseCode.FAIL);
    }

    /**
     * 参数校验异常统一处理
     *
     * @param methodArgumentNotValidException requestBody参数校验返回错误
     * @param t                               get请求返回错误
     * @return 响应结果
     */
    @BindingExceptionHandlers({BindException.class, MethodArgumentNotValidException.class})
    public Response bindExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException, BindException t) {
        BindingResult result = null;
        if (methodArgumentNotValidException != null) {
            result = methodArgumentNotValidException.getBindingResult();
        }
        if (t != null) {
            result = t.getBindingResult();
        }
        assert result != null;
        Set<String> errors = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toSet());
        return Response.fail(ResponseCode.PARAMENT_ERROR, errors);
    }

    @ExceptionHandler(BindException.class)
    public Response bindExceptionHandler(BindException t) {
        if (t!=null){
            Set<String> collect = t.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toSet());
            return Response.fail(collect);
        }
        return Response.fail(ResponseCode.FAIL);
    }
    @ExceptionHandler( MethodArgumentNotValidException.class)
    public Response bindExceptionHandler(MethodArgumentNotValidException t) {
        if (t!=null){
            Set<String> collect = t.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toSet());
            return Response.fail(collect);
        }
        return Response.fail(ResponseCode.FAIL);
    }
}
