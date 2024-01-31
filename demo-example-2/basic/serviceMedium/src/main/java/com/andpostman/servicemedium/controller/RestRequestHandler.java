package com.andpostman.servicemedium.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serviceMedium")
public class RestRequestHandler {

    @GetMapping("/report")
    public String report(){
        return "The ServiceMedium is ready";
    }
}
