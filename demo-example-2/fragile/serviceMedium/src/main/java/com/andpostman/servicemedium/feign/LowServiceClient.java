package com.andpostman.servicemedium.feign;

import com.andpostman.servicemedium.properties.RandomNumber;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "service-low", url = "${service-low.url}")
public interface LowServiceClient {

    @PostMapping("/serviceLow/multiply")
    RandomNumber multiply(@RequestBody RandomNumber number);

}
