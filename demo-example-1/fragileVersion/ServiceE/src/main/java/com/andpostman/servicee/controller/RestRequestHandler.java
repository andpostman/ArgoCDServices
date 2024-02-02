package com.andpostman.servicee.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;
import com.andpostman.servicee.dto.RandomNumberDescription;
import com.andpostman.servicee.service.DataConversionServiceImpl;

@RestController("RestRequestHandlerServiceEv3")
@RequiredArgsConstructor
@Slf4j
public class RestRequestHandler {

    private final DataConversionServiceImpl dataConversionService;

    @GetMapping("get")
    public RandomNumberDescription get(@RequestHeader @Nullable HttpHeaders headers) {
        log.info("Вызов ServiceE");
        return dataConversionService.responseFromDB();
    }

}
