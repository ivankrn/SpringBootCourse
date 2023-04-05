package com.ivankrn.springbootcourse.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("test")
@Slf4j
public class TestPrinter {

    @Autowired
    TestConfig testConfig;

    @PostConstruct
    public void postConstruct() {
        log.info("Current name is {}", testConfig.getAppName());
        log.info("Launched on OS: {}", testConfig.getLaunchedOn());
    }

}
