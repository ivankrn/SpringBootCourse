package com.ivankrn.springbootcourse.controller;

import com.ivankrn.springbootcourse.database.MapStructMapper;
import com.ivankrn.springbootcourse.database.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
@RequiredArgsConstructor
@Endpoint(id = "users")
@Slf4j
public class UserStatsEndpoint {

    private final UserRepository userRepository;
    private final MapStructMapper mapStructMapper;

    @ReadOperation
    public long count() {
        log.info("New users count request, current timestamp: {}", Instant.now());
        return userRepository.count();
    }


}
