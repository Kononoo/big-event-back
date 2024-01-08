package com.ronan.exception;

import com.ronan.entity.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * ClassName: GlobalExceptionHandler
 * Package: com.ronan.exception
 * Description:
 *
 * @Author: Ronan
 * @Create 2024/1/8 - 15:34
 * @Version: v1.0
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R<String> exceptionHandler(Exception exception) {
        log.error(exception.getMessage());
        return R.error(StringUtils.hasLength(exception.getMessage()) && exception.getMessage().length() < 30 ? exception.getMessage() : "服务异常");
    }
}
