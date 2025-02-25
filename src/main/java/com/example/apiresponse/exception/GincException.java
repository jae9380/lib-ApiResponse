package com.example.apiresponse.exception;

import lombok.Generated;
import lombok.Getter;

@Getter
public class GincException extends RuntimeException {
    private final ErrorCode errorCode;

    public GincException(ErrorCode e) {
        super(e.getMessage());
        this.errorCode = e;
    }

    @Generated
    public ErrorCode getErrorCode() {
        return this.errorCode;
    }
}