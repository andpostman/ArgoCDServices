package com.andpostman.servicehigh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.andpostman.servicehigh.properties.RandomNumber;

@FeignClient(value = "service-medium", url = "${service-medium.url}")
public interface MediumServiceClient {

    @PostMapping("/serviceMedium/subtract")
    RandomNumber subtract(@RequestBody RandomNumber number);
}
