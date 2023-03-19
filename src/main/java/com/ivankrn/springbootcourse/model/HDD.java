package com.ivankrn.springbootcourse.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class HDD extends StorageDevice {
    @NonNull
    private int readSpeedInMB;
    @NonNull
    private int writeSpeedInMB;
}
