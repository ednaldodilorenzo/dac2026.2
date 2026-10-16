package com.example.base.core.exception;

import lombok.Getter;

@Getter
public class APIException extends RuntimeException {
    private APIExceptionType type;

    public APIException(APIExceptionType exceptionType, String message) {
        super(message);
        this.type = exceptionType;
    }
}
