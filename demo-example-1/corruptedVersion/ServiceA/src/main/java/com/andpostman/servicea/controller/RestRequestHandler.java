package com.andpostman.servicea.controller;

import com.andpostman.servicea.dto.RandomNumber;
import com.andpostman.servicea.dto.WorkTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import com.andpostman.servicea.service.impl.CallServiceImpl;

@RestController("RestRequestHandlerServiceAv2")
@RequiredArgsConstructor
@Slf4j
public class RestRequestHandler {

    private final WorkTime timeInitialise = WorkTime.getInstance();

    private final CallServiceImpl callService;

    @PostMapping("calc")
    public String calc(@RequestBody @Nullable RandomNumber random, @RequestHeader @Nullable HttpHeaders headers){
        log.info("Вызов ServiceA");
        String response = callService.responseFromServices();
        callService.checkForLogicalError(timeInitialise);
        return response;
    }

}

