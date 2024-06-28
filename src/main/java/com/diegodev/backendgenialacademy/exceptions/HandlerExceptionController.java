package com.diegodev.backendgenialacademy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> userNotFound(Exception ex){
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setDate(new Date());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(RequestException.class)
    public ResponseEntity<Error> requestExceptionHandler(RequestException ex){
        Error error = new Error();
        error.setMessage(ex.getMessage());
        error.setStatus(ex.getStatus().value());
        error.setDate(new Date());
        return new ResponseEntity<>(error, ex.getStatus());
    }
}
