package com.solinagro.visionid.common.utilities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiResult {

    private String requestId;
    private String message;
    private String error;
    private HttpStatus statusResponse;
    private Object response;

}
