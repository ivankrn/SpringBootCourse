package com.ivankrn.springbootcourse.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RAM {
    @Getter
    private final int sizeInGB;
}
