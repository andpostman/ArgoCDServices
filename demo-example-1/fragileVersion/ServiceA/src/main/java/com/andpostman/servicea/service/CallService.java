package com.andpostman.servicea.service;

import reactor.core.publisher.Flux;

public interface CallService {
    Flux<Integer> calcSumOfServicesNumbers();
    String responseFromServices();
}
