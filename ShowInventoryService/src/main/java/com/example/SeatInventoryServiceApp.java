package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
//@ComponentScan({"com.example.persistence.entity.*"})

@EntityScan(basePackages = "com.example.*")
public class SeatInventoryServiceApp {

    public static void main(String[] args) {
        SpringApplication.run(SeatInventoryServiceApp.class, args);
        System.out.println("Started Spring Server");
    }
}
