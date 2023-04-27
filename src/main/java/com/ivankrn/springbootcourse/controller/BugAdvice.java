package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class BugAdvice {

    private static final String message = "Validation error!";

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleNotValid(MethodArgumentNotValidException ex) {
        BindingResult errors = ex.getBindingResult();
        Map<String, String> validationsErrors = new HashMap<>();
        for (FieldError error : errors.getFieldErrors()) {
            validationsErrors.put(error.getField(), error.getDefaultMessage());
        }
        ErrorResponse error = new ErrorResponse(message, validationsErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
