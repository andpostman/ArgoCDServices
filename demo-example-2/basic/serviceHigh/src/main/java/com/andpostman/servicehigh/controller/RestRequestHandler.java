package com.andpostman.servicehigh.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceHigh")
public class RestRequestHandler {

    @GetMapping("/report")
    public String report(){
        return "The ServiceHigh is ready";
    }
}
