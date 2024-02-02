package com.andpostman.servicec.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import com.andpostman.servicec.dto.RandomNumber;
import com.andpostman.servicec.service.impl.CallServiceImpl;

@RestController("RestRequestHandlerServiceCv3")
@RequiredArgsConstructor
@Slf4j
public class RestRequestHandler {

    private final CallServiceImpl callService;

    @PostMapping("calc")
    public RandomNumber calc(@RequestBody @Nullable RandomNumber random, @RequestHeader @Nullable HttpHeaders headers){
        log.info("Вызов ServiceC");
        return callService.responseFromServices();
    }

}
