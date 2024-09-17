package com.solinagro.visionid.common.controllers;

import com.solinagro.visionid.common.exceptions.VisionException;
import com.solinagro.visionid.common.utilities.ApiResult;
import com.solinagro.visionid.common.wrapper.AbstractServiceWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@Slf4j
@RestControllerAdvice
public class BaseController extends AbstractServiceWrapper {

    @ExceptionHandler(value = VisionException.class)
    public ResponseEntity<ApiResult> handleVisionException(VisionException e) {
        log.warn("Vision exception controller: {0}", e.getCause());
        return createResponseEntity(createApiResult("Vision Exception", e.getMessage(), HttpStatus.BAD_REQUEST, null));
    }

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ApiResult> handleException(Exception e) {
        log.error("Exception controller cause: {0}", e.getCause());
        log.warn("Exception controller went wrong: {}", (Object) e.getStackTrace());
        return createResponseEntity(createApiResult("Exception control", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null));
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<ApiResult> handleRuntimeException(RuntimeException e) {
        log.error("Runtime exception controller: {0}", e.getCause());
        log.warn("Something in runtime exception went wrong: {}", e.getMessage());
        return createResponseEntity(createApiResult("Runtime exception control", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, null));
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ApiResult> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("Illegal arguments exception controller: {0}", e.getCause());
        log.warn("Illegal arguments exception controller: {}", e.getMessage());
        return createResponseEntity(createApiResult("Illegal arguments exception control", e.getMessage(), HttpStatus.BAD_REQUEST, null));
    }

}
