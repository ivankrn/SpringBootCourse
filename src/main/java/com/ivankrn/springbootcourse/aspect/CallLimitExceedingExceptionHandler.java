package com.ivankrn.springbootcourse.aspect;

import com.ivankrn.springbootcourse.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class CallLimitExceedingExceptionHandler {

    private static final String message = "API call limit exceeded!";

    @ExceptionHandler(CallLimitExceedingException.class)
    protected ResponseEntity<ErrorResponse> handleException(CallLimitExceedingException exception) {
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(
                new ErrorResponse(message));
    }
}
