package com.novi.TechItEasy.exception;

public class RecordNotFoundException extends RuntimeException {
    private String message;
    public RecordNotFoundException (String message){
        super(message);
    }
    public RecordNotFoundException (String message, Throwable cause){
        super(message,cause);
    }
}
