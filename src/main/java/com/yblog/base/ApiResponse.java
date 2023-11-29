package com.yblog.base;

import lombok.Builder;
import lombok.Getter;

@Getter
public class ApiResponse {

    private Object result;

    private int resultCode;

    private String resultMsg;

    @Builder
    public ApiResponse(final Object result, final int resultCode, final String resultMsg) {
        this.result = result;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
    }
}
