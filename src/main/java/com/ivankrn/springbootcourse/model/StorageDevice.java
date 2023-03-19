package com.ivankrn.springbootcourse.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public abstract class StorageDevice {
    @NonNull
    private int readSpeedInMb;
    @NonNull
    private int writeSpeedInMb;
}
