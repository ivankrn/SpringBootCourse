package com.ivankrn.springbootcourse.service;

import com.ivankrn.springbootcourse.database.BugDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerService {
    @Autowired
    private KafkaTemplate<String, BugDto> kafkaTemplate;

    public static final String kafkaTopic = "bug";

    public void send(BugDto bug) {
        log.info("Sending bug with title: {}", bug.getTitle());
        kafkaTemplate.send(kafkaTopic, bug);
    }
}
