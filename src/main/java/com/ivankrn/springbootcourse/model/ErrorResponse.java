package com.ivankrn.springbootcourse.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class ErrorResponse {
    private String message;
    private OffsetDateTime date;
    private Object data;

    public ErrorResponse(String message) {
        this.message = message;
        this.date = OffsetDateTime.now();
    }

    public ErrorResponse(String message, Object data) {
        this(message);
        this.data = data;
    }
}
