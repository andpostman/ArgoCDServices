package com.andpostman.servicee.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import com.andpostman.servicee.dto.RandomNumber;
import com.andpostman.servicee.service.RandomNumberGenerationServiceImpl;

@RestController("RestRequestHandlerServiceEv1")
@RequiredArgsConstructor
@Slf4j
public class RestRequestHandler {

    private final RandomNumberGenerationServiceImpl numberGenerationService;

    @GetMapping("get")
    public RandomNumber get(@RequestHeader @Nullable HttpHeaders headers) {
        log.info("Вызов ServiceE");
        return numberGenerationService.generateNumber();
    }

}
