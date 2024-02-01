package com.andpostman.serviced.service;

import com.andpostman.serviced.dto.RandomNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("RandomNumberGenerationServiceImplServiceDv1")
@Slf4j
public class RandomNumberGenerationServiceImpl implements RandomNumberGenerationService{

    @Override
    public RandomNumber generateNumber() {
        RandomNumber number = new RandomNumber();
        log.info("ServiceD сгенерировал число: " + number);
        return number;
    }
}
