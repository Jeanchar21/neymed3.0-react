package com.neymed.neyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.neymed.neyapi")
@EnableJpaRepositories(basePackages = "com.neymed.neyapi")
public class ApplicationNey {
    public static void main(String[] args){
        SpringApplication.run(ApplicationNey.class, args);
    }
}