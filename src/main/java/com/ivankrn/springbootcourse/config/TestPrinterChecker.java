package com.ivankrn.springbootcourse.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConditionalOnBean(TestPrinter.class)
@Slf4j
public class TestPrinterChecker {

    @PostConstruct
    public void postConstruct() {
        log.info("Test printer bean exists");
    }

}
