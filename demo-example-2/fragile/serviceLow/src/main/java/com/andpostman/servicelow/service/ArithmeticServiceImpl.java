package com.andpostman.servicelow.service;

import com.andpostman.servicelow.properties.RandomNumber;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ArithmeticServiceImpl implements ArithmeticService{

    @Override
    public RandomNumber getMultiplicationWithNumber(RandomNumber number) {
        log.info("number: " + number);
        RandomNumber result = new RandomNumber();
        log.info("newNumber: " + result);
        if (number.getNumber() == 0) {
            result.setNumber(0);
            log.info("result of multiplication: " + result);
            return result;
        }
        result.setNumber(number.getNumber() * result.getNumber());
        log.info("result of multiplication: " + result);
        return result;
    }

    @Override
    public RandomNumber getDivisionWithNumber(RandomNumber number) {
        log.info("number: " + number);
        RandomNumber result = new RandomNumber();
        log.info("newNumber: " + result);
        if (number.getNumber() == 0) {
            result.setNumber(0);
            log.info("result of division: " + result);
            return result;
        }
        result.setNumber(number.getNumber() / result.getNumber());
        log.info("result of division: " + result);
        return result;
    }
}
