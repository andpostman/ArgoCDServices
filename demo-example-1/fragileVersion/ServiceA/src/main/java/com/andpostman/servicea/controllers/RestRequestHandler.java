package com.andpostman.servicea.controllers;

import com.andpostman.servicea.dto.RandomNumber;
import com.andpostman.servicea.service.impl.CallServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController("RestRequestHandlerServiceAv3")
@Slf4j
@RequiredArgsConstructor
public class RestRequestHandler {

    private final CallServiceImpl callService;

    @PostMapping("calc")
    public String calc(@RequestBody @Nullable RandomNumber random, @RequestHeader @Nullable HttpHeaders headers){
        log.info("Вызов ServiceA");
        return callService.responseFromServices();
    }

}

