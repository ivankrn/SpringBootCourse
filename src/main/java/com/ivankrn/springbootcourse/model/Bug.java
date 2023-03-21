package com.ivankrn.springbootcourse.model;

import lombok.Data;

import java.time.OffsetDateTime;

@Data
public class Bug {
    private int id;
    private int title;
    private int severity;
    private OffsetDateTime createdAt;
}
