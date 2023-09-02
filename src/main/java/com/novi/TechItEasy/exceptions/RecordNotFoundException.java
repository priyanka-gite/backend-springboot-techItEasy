package com.novi.TechItEasy.exceptions;

public class RecordNotFoundException extends RuntimeException {
    private String message;
    public RecordNotFoundException (String message){
        super(message);
    }
    public RecordNotFoundException (String message, Throwable cause){
        super(message,cause);
    }
}
