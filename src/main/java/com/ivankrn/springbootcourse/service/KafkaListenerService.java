package com.ivankrn.springbootcourse.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class KafkaListenerService {

    private final KafkaProducerService kafkaProducerService;

    @KafkaListener(topics = "bug-response", containerFactory = "bugResponseKafkaListenerContainerFactory")
    public void listen(String message) {
        log.info("Message from repeater: {}", message);
    }

}
