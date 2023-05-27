package com.ivankrn.springbootcourse.event;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class BugCreatedEvent {
    private final String title;
    private final int severity;
}
