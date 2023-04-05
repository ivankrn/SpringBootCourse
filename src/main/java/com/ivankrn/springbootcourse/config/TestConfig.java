package com.ivankrn.springbootcourse.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties
@Getter
@Setter
public class TestConfig {
    private String appName;
    private List<String> ports;
    private String launchedOn;
}
