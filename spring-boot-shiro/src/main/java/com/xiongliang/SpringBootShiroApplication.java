package com.xiongliang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootShiroApplication  extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootShiroApplication.class, args);
    }

}
