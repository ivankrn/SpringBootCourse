package com.ivankrn.springbootcourse.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private OffsetDateTime date;
    private List<String> details;
}
