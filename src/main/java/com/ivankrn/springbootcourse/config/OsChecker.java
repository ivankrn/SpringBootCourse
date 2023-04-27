package com.ivankrn.springbootcourse.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@ConditionalOnExpression("!'${info.launchedOn}'.equals('default')")
@Slf4j
public class OsChecker {
    @PostConstruct
    public void postConstruct() {
        log.info("OS environment variable checked");
    }
}
