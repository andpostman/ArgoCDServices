package com.andpostman.serviceb.service;

import com.andpostman.serviceb.dto.RandomNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("RandomNumberGenerationServiceBImplV3")
@Slf4j
public class RandomNumberGenerationServiceImpl implements RandomNumberGenerationService{

    @Override
    public RandomNumber generateNumber() {
        RandomNumber number = new RandomNumber();
        log.info("ServiceB сгенерировал число: " + number);
        return number;
    }
}
