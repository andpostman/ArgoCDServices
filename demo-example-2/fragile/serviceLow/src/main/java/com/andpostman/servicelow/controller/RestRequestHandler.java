package com.andpostman.servicelow.controller;

import com.andpostman.servicelow.properties.RandomNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import com.andpostman.servicelow.service.ArithmeticServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/serviceLow")
public class RestRequestHandler {

    private final ArithmeticServiceImpl service;

    @PostMapping("/multiply")
    public RandomNumber multiply (@RequestBody RandomNumber number, @RequestHeader @Nullable HttpHeaders headers){
        return service.getMultiplicationWithNumber(number);
    }

    @PostMapping("/divide")
    public RandomNumber divide (@RequestBody RandomNumber number, @RequestHeader @Nullable HttpHeaders headers){
        return service.getDivisionWithNumber(number);
    }
}
