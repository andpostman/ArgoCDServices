package com.andpostman.servicec.service;

import reactor.core.publisher.Mono;
import com.andpostman.servicec.dto.RandomNumber;

public interface WebService {
    Mono<RandomNumber> getResponseFromServiceE();
    Mono<RandomNumber> getResponseFromServiceD();
}
