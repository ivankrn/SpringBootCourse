package com.ivankrn.springbootcourse.model;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class SSD extends StorageDevice {
    @Getter
    @Setter
    @NonNull
    private int readSpeedInMB;
    @Getter
    @Setter
    @NonNull
    private int writeSpeedInMB;
}
