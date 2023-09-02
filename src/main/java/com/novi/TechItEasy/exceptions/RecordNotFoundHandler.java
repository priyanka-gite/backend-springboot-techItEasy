package com.novi.TechItEasy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;
@ControllerAdvice
public class RecordNotFoundHandler {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> handleRecordnotFoundException(RecordNotFoundException e){
// 1.create payload containing  exception  details;
        HttpStatus notFound = HttpStatus.NOT_FOUND;
       RecordException recordException=  new RecordException(
                e.getMessage(),
               notFound
        );
// 2. Return response entity
        return new ResponseEntity<>(recordException,notFound);
    }
}
