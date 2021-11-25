package com.dqb.cloud_common.config;

import com.dqb.cloud_common.exception.NeiApiException;
import com.dqb.cloud_common.response.Result;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Ddescription
 * @Author 丁庆斌
 **/
@RestControllerAdvice
public class GlobleExceptionHandle {




    @ExceptionHandler({NeiApiException.class})
    public Result errorHandler1(NeiApiException exception, HttpServletRequest request, HttpServletResponse response) {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=UTF-8");

        return Result.fail(exception.getCode(),exception.getMessage(),null);
    }

    @ExceptionHandler({Exception.class})
    public Result errorHandler(Exception exception, HttpServletRequest request) {
        System.out.println("---------进入统一异常处理-----------");
        Result result = Result.fail(100,"统一错误处理",null);
        return result;
    }
}
