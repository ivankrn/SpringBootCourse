package com.ivankrn.springbootcourse.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
@Slf4j
public class BugGroupCreatedListener {

    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    void handleBugGroupCreatedEvent(BugGroupCreatedEvent event) {
        log.info("Bug group {} will be persisted with total bugs count: {}", event.getName(), event.getBugsCount());
    }

}
