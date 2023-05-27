package com.ivankrn.springbootcourse.database;

import com.ivankrn.springbootcourse.model.SeverityConstraint;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.Instant;

@Getter
@Setter
public class BugDto {
    private long id;
    @NotBlank
    private String title;
    @NotNull
    @SeverityConstraint
    private int severity;
    private Instant createdAt;
    private Instant updatedAt;
    @NotNull
    private BugGroupSlimDto group;
}
