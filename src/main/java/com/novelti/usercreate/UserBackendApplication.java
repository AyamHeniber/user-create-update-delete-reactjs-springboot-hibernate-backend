package com.novelti.usercreate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.novelti.usercreate")
@EntityScan(basePackages = "com.novelti.usercreate.entity")
public class UserBackendApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserBackendApplication.class, args);
    }
}

