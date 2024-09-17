package com.solinagro.visionid.common.wrapper;

import com.solinagro.visionid.common.utilities.ApiResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class AbstractServiceWrapper {

    protected UUID generateRequestId() {
        return UUID.randomUUID();
    }

    protected ApiResult createApiResult(String message, String error, HttpStatus status, Object objectResponse) {
        return ApiResult.builder()
                .requestId(generateRequestId().toString())
                .message(message)
                .error(error)
                .statusResponse(status)
                .response(objectResponse)
                .build();
    }

    protected ResponseEntity<ApiResult> createResponseEntity(ApiResult apiResult) {
        return ResponseEntity.ok(apiResult);
    }

    protected ResponseEntity<ApiResult> createResponseEntity(String message, String error, HttpStatus status, Object objectResponse) {
        return createResponseEntity(ApiResult.builder()
                .requestId(generateRequestId().toString())
                .message(message)
                .error(error)
                .statusResponse(status)
                .response(objectResponse)
                .build());
    }

}
