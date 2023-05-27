package com.ivankrn.springbootcourse.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BugGroupCreatedEvent {
    private final String name;
    private final int bugsCount;
}
