package com.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@Slf4j
@EntityScan(basePackages = "com.example.*")
public class SeatInventoryServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(SeatInventoryServiceApp.class, args);
        log.info("Started Spring Server");
    }
}
