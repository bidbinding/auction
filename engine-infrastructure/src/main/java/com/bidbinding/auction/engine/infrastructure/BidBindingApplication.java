package com.bidbinding.auction.engine.infrastructure;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.bidbinding")
public class BidBindingApplication {

    public static void main(String[] args) {
        SpringApplication.run(BidBindingApplication.class, args);
    }

}
