package com.ivankrn.springbootcourse.config;

import com.ivankrn.springbootcourse.model.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelConfig {

    @Bean
    public CPU intelCPU() {
        return new x86CPU("Intel");
    }

    @Bean
    public CPU snapdragonCPU() {
        return new ARMCPU("Snapdragon");
    }

    @Bean
    public StorageDevice slowHDD() {
        return new HDD(100, 100);
    }

    @Bean
    public StorageDevice fastSSD() {
        return new SSD(500, 500);
    }

    @Bean
    public RAM averageRAM() {
        return new RAM(8);
    }
}
