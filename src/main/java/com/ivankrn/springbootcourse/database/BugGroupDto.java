package com.ivankrn.springbootcourse.database;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BugGroupDto {
    private long id;
    private String name;
    private Set<BugSlimDto> bugs;
}
