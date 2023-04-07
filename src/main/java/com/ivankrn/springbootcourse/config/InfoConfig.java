package com.ivankrn.springbootcourse.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "info")
@Getter
@Setter
public class InfoConfig {
    private String appName;
    private List<Integer> ports;
    private String launchedOn;
}
