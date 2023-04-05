package com.ivankrn.springbootcourse.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConditionalOnProperty(name = "launchedOn", havingValue = "Windows_NT")
@Slf4j
public class OsChecker {
    @PostConstruct
    public void postConstruct() {
        log.info("OS checked");
    }
}
