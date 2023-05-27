package com.ivankrn.springbootcourse.database;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@Setter
public class BugGroupDto {
    private long id;
    @NotBlank
    private String name;
    private Set<BugSlimDto> bugs;
}
