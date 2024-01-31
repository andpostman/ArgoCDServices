package com.andpostman.servicehigh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ServiceHighApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHighApplication.class, args);
    }

}
