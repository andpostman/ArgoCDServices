package com.andpostman.servicelow.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/serviceLow")
public class RestRequestHandler {

    @GetMapping("/report")
    public String report(){
        return "The ServiceLow is ready";
    }
}
