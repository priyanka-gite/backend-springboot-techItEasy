package com.novi.TechItEasy.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RecordNotFoundHandler {
    @ExceptionHandler(value = RecordNotFoundException.class)
    public ResponseEntity<Object> handleRecordnotFoundException(RecordNotFoundException e){

// 1.create payload containing  exception  details;
        HttpStatus notFound = HttpStatus.NOT_FOUND;
       RecordNotFound recordNotFound;
        recordNotFound = new RecordNotFound(
                 e.getMessage(),
                notFound
         );
// 2. Return response entity
        return new ResponseEntity<>(recordNotFound,notFound);
    }
}
