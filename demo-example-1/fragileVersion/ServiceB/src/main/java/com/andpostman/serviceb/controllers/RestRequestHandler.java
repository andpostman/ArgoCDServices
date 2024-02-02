package com.andpostman.serviceb.controllers;

import com.andpostman.serviceb.dto.RandomNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import com.andpostman.serviceb.service.RandomNumberGenerationServiceImpl;

@RestController("RestRequestHandlerServiceBv3")
@RequiredArgsConstructor
@Slf4j
public class RestRequestHandler {

    private final RandomNumberGenerationServiceImpl numberGenerationService;

    @PostMapping("prepare")
    public void prepare(@RequestHeader @Nullable HttpHeaders headers){
        log.info("Подготовка ServiceB");
    }

    @GetMapping("get")
    public RandomNumber get(@RequestHeader @Nullable HttpHeaders headers) {
        log.info("Вызов ServiceB");
        return numberGenerationService.generateNumber();
    }

}
