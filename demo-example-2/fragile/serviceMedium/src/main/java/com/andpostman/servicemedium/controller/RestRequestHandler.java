package com.andpostman.servicemedium.controller;

import com.andpostman.servicemedium.properties.RandomNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import com.andpostman.servicemedium.service.ArithmeticServiceImpl;

@RestController
@RequiredArgsConstructor
@RequestMapping("/serviceMedium")
public class RestRequestHandler {

    private final ArithmeticServiceImpl analyticalService;

    @PostMapping("/subtract")
    public RandomNumber subtract(@RequestBody RandomNumber number, @RequestHeader @Nullable HttpHeaders headers){
        return analyticalService.subtractionAndMultiplicationWithNumber(number);
    }
}
