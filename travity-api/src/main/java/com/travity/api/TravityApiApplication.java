package com.travity.api;

import lombok.Generated;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@Generated
@ComponentScan(basePackages = { "com.travity" })
@EntityScan(basePackages = { "com.travity" })
@EnableJpaAuditing
public class TravityApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TravityApiApplication.class, args);
    }
}
