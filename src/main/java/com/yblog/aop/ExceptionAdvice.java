package com.yblog.aop;

import com.yblog.base.ErrorEntity;
import com.yblog.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
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

    @ExceptionHandler(CustomException.class)
    protected ErrorEntity handleCustomException(CustomException e) {
        log.error("CustomException", e);
        return new ErrorEntity(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ErrorEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
//        log.error("handleMethodArgumentNotValidException", e);
//        BindingResult bindingResult = e.getBindingResult();
//        StringBuilder stringBuilder = new StringBuilder();
//        for (FieldError fieldError : bindingResult.getFieldErrors()) {
//            stringBuilder.append(fieldError.getField()).append(":");
//            stringBuilder.append(fieldError.getDefaultMessage());
//            stringBuilder.append(", ");
//        }
        return new ErrorEntity(e.getMessage());
    }

}
