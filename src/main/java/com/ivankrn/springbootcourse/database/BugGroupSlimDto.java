package com.ivankrn.springbootcourse.database;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class BugGroupSlimDto {
    private long id;
    @NotBlank
    private String name;
}
