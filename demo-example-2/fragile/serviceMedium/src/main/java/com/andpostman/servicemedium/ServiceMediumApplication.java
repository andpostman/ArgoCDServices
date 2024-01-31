package com.andpostman.servicemedium;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceMediumApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceMediumApplication.class, args);
    }

}
