package com.andpostman.servicehigh.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.andpostman.servicehigh.properties.RandomNumber;

@FeignClient(value = "service-low", url = "${service-low.url}")
public interface LowServiceClient {

    @PostMapping("/serviceLow/divide")
    RandomNumber divide (@RequestBody RandomNumber number);
}
