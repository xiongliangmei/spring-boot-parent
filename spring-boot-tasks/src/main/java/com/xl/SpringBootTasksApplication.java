package com.xl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBootTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootTasksApplication.class, args);
    }

}
