package com.ivankrn.springbootcourse.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class NotFoundExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {NotFoundException.class})
    protected ResponseEntity<Object> handleException(RuntimeException exception, WebRequest request) {
        String responseBody = "Not found!";
        return handleExceptionInternal(exception, responseBody, new HttpHeaders(), HttpStatus.BAD_GATEWAY, request);
    }
}
