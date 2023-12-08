package com.yblog.util;

import com.yblog.base.ApiResponse;
import com.yblog.base.ErrorEntity;

public class ResponseUtil {
    public static <T> ApiResponse<T> success(T response) {
        return new ApiResponse<> (true, response, null);
    }
    public static ApiResponse<?> error(ErrorEntity e) {
        return new ApiResponse<> (false, null, e);
    }

}
