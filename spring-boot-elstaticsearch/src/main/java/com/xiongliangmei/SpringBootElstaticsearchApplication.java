package com.xiongliangmei;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@Configuration
public class SpringBootElstaticsearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootElstaticsearchApplication.class, args);
    }

}
