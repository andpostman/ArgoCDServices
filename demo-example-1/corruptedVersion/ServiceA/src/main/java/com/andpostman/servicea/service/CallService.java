package com.andpostman.servicea.service;

import reactor.core.publisher.Flux;
import com.andpostman.servicea.dto.WorkTime;

public interface CallService {
    Flux<Integer> calcSumOfServicesNumbers();
    String responseFromServices();
    void checkForLogicalError(WorkTime workTime);
}
