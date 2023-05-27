package com.ivankrn.springbootcourse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCourseApplication.class, args);
    }

}
