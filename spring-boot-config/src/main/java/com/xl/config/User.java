package com.xl.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:test.properties")
@ConfigurationProperties(prefix = "com.forezp")
@Data
public class User {
    private String name;
    private String age;

}
