package com.novi.TechItEasy.exceptions;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class RecordException {
    private final String message;
    private final Throwable throwable;
    private final HttpStatus httpStatus;
    private final ZonedDateTime timeStamp;

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ZonedDateTime getTimeStamp() {
        return timeStamp;
    }

    public RecordException(String message, Throwable throwable, HttpStatus httpStatus, ZonedDateTime timeStamp) {
        this.message = message;
        this.throwable = throwable;
        this.httpStatus = httpStatus;
        this.timeStamp = timeStamp;
    }
}
