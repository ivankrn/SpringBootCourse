package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.model.ErrorResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class MethodArgumentNotValidExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        List<String> validationErrors = new ArrayList<>();
        for (ObjectError error : ex.getAllErrors()) {
            validationErrors.add(error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse(OffsetDateTime.now(), validationErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
