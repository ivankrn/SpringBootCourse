package com.ivankrn.springbootcourse.database;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class BugSlimDto {
    private long id;
    private String title;
    private int severity;
    private Instant createdAt;
    private Instant updatedAt;
}
