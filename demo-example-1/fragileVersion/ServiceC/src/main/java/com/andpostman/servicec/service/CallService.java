package com.andpostman.servicec.service;

import reactor.core.publisher.Flux;
import com.andpostman.servicec.dto.RandomNumber;

public interface CallService {
    Flux<Integer> calcSumOfServicesNumbers();
    RandomNumber responseFromServices();
}
