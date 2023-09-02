package com.novi.TechItEasy.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class RecordException {
    private final String message;
    private final HttpStatus httpStatus;

    public RecordException(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
