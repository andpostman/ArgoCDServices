package com.andpostman.servicehigh.controller;

import com.andpostman.servicehigh.properties.RandomNumber;
import com.andpostman.servicehigh.service.ArithmeticServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/serviceHigh")
public class RestRequestHandler {

    private final ArithmeticServiceImpl service;

    @PostMapping("/calculate")
    public String calculate(@RequestBody RandomNumber number, @RequestHeader @Nullable HttpHeaders headers){
        return service.calculateNumbers(number);
    }

}
