package com.andpostman.serviced.controllers;

import com.andpostman.serviced.dto.RandomNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import com.andpostman.serviced.service.RandomNumberGenerationServiceImpl;

@RestController("RestRequestHandlerServiceDv1")
@RequiredArgsConstructor
@Slf4j
public class RestRequestHandler {

    private final RandomNumberGenerationServiceImpl numberGenerationService;

    @GetMapping("get")
    public RandomNumber get(@RequestHeader @Nullable HttpHeaders headers) {
        log.info("Вызов ServiceD");
        return numberGenerationService.generateNumber();
    }

}
