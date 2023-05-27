package com.ivankrn.springbootcourse.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BugCreatedListener {

    @EventListener
    void handleBugCreatedEvent(BugCreatedEvent event) {
        log.info("Created new bug: {}", event.getTitle());
    }

    @Async
    @EventListener(condition = "#event.severity > 5")
    void handleSeriousBugCreatedEvent(BugCreatedEvent event) {
        log.warn("Caution! Created new very serious bug: {}", event.getTitle());
        // будто отправляем уведомление через посторонний сервис
    }
}
