package com.ivankrn.springbootcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableKafka
public class SpringBootCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCourseApplication.class, args);
    }

}
