package com.andpostman.servicea.service;

import reactor.core.publisher.Mono;
import com.andpostman.servicea.dto.RandomNumber;

public interface WebService {
    void postResponseFromServiceB();
    Mono<RandomNumber> getResponseFromServiceB();
    Mono<RandomNumber> getResponseFromServiceC();
}
