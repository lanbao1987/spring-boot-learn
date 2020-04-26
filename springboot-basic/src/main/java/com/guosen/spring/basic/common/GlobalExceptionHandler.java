package com.guosen.spring.basic.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice(basePackages = "com.guosen.spring")
@ResponseBody
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ReturnResult handleUnexpectedServer(Exception ex) {
        log.error("系统异常：", ex);
        return new ReturnResult("500", "系统发生异常，请联系管理员");
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ReturnResult handleHttpMessageNotReadableException(MissingServletRequestParameterException ex) {
        log.error("bad request..", ex);
        return new ReturnResult("400", "入参异常");
    }

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ReturnResult handleTypeMismatchException(NullPointerException ex) {
        log.error("空指针异常", ex);
        return new ReturnResult("500", "空指针异常了");
    }


}
