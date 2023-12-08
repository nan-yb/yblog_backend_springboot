package com.yblog.aop;

import com.yblog.base.ErrorEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.security.auth.login.FailedLoginException;


@RestControllerAdvice
public class ExceptionAdvice {

    Logger log = LoggerFactory.getLogger(ExceptionAdvice.class);

    @ExceptionHandler(FailedLoginException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorEntity handleLoginException(FailedLoginException e) {

        log.error("Login Exception({}) - {}", e.getClass().getSimpleName(), e.getMessage());
        return new ErrorEntity(e.getMessage());
    }
}
