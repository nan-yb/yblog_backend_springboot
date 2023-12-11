package com.yblog.aop;

import com.yblog.base.ErrorEntity;
import com.yblog.exception.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        return new ErrorEntity(e.getMessage());
    }

    @ExceptionHandler(CustomException.class)
    protected ErrorEntity handleCustomException(CustomException e) {
        return new ErrorEntity(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ErrorEntity handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ErrorEntity(e.getMessage());
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    protected ErrorEntity UsernameNotFoundExceptionException(UsernameNotFoundException e) {
        return new ErrorEntity(e.getMessage());
    }

}
