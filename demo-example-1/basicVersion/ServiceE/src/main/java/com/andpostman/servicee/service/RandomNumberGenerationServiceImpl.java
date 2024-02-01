package com.andpostman.servicee.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.andpostman.servicee.dto.RandomNumber;

@Service("RandomNumberGenerationServiceImplServiceEv1")
@Slf4j
public class RandomNumberGenerationServiceImpl implements RandomNumberGenerationService{

    @Override
    public RandomNumber generateNumber() {
        RandomNumber number = new RandomNumber();
        log.info("ServiceE сгенерировал число: " + number);
        return number;
    }
}
