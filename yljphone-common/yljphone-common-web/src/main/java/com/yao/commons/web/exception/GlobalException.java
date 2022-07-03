package com.yao.commons.web.exception;

import com.yao.commons.web.resp.Response;
import com.yao.commons.web.resp.ResponseCode;
import com.yao.commons.web.utils.RequestUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
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
     * @param t 参数校验异常
     * @return 响应结果
     */
    @ExceptionHandler(BindException.class)
    public Response bindExceptionHandler(BindException t) {
        Set<String> errors = t.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toSet());
        return Response.fail(ResponseCode.PARAMENT_ERROR, errors);
    }
}
