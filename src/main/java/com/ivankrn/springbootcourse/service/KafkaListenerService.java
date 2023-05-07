package com.ivankrn.springbootcourse.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaListenerService {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @KafkaListener(topics = "bug-response", containerFactory = "bugResponseKafkaListenerContainerFactory")
    public void listen(String message) {
        log.info("Message from repeater: {}", message);
    }

}
