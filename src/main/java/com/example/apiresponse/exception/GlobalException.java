package com.example.apiresponse.exception;

import static com.example.apiresponse.exception.ErrorCode.*;

public class GlobalException extends GincException {
    public GlobalException(ErrorCode e) {
        super(e);
    }
    public static class BadInputFormatException extends GincException {
        public BadInputFormatException() {
            super(BAD_INPUT_FORMAT);
        }
    }
    public static class NotAuthorizedException extends GincException {
        public NotAuthorizedException() {
            super(NOT_AUTHORIZED);
        }
    }
}
