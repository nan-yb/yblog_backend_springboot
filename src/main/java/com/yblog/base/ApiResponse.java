package com.yblog.base;

import com.yblog.exception.CustomException;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ApiResponse {

    private Object data;
    private HttpStatus status;
    private String statusText;
    private CustomException exception;

    @Builder
    public ApiResponse(HttpStatus status , CustomException e) {
        this.status = status;
        this.exception = e;
    }

    @Builder
    public ApiResponse(Object data, HttpStatus status) {
        this.data = data;
        this.status = status;
    }

    @Builder
    public ApiResponse(Object data, HttpStatus status, String statusText) {
        this.data = data;
        this.status = status;
        this.statusText = statusText;
    }
}
