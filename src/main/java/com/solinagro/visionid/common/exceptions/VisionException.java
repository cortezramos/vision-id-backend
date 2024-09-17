package com.solinagro.visionid.common.exceptions;

import java.io.Serial;

public class VisionException extends Exception {

    @Serial
    private static final long serialVersionUID = 1L;

    public VisionException() {}

    public VisionException(String message) {
        super(message);
    }

    public VisionException(String message, Throwable cause) {
        super(message, cause);
    }

    public VisionException(Throwable cause) {
        super(cause);
    }

    public VisionException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
