package com.ivankrn.springbootcourse.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class NotFoundExceptionHandler {
    public static final String message = "Not found!";

    @ExceptionHandler(NotFoundException.class)
    protected ResponseEntity<?> handleException(NotFoundException exception) {
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(message);
    }
}
