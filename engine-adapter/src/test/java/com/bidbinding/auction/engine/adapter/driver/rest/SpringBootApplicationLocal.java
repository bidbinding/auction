package com.bidbinding.auction.engine.adapter.driver.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.bidbinding")
@SpringBootApplication
public class SpringBootApplicationLocal {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplicationLocal.class, args);
    }
}
