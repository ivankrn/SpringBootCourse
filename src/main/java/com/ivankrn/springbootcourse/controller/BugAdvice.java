package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class BugAdvice {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleNotValid(MethodArgumentNotValidException ex) {
        BindingResult errors = ex.getBindingResult();
        List<String> validationsErrors = new ArrayList<>();
        for (FieldError error : errors.getFieldErrors()) {
            validationsErrors.add(String.format("%s: %s", error.getField(), error.getDefaultMessage()));
        }
        ErrorResponse error = new ErrorResponse(OffsetDateTime.now(), validationsErrors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
