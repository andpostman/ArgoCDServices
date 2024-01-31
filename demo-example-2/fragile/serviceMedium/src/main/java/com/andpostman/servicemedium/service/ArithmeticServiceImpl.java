package com.andpostman.servicemedium.service;

import com.andpostman.servicemedium.properties.RandomNumber;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.andpostman.servicemedium.feign.LowServiceClient;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArithmeticServiceImpl implements ArithmeticService{

    private final LowServiceClient lowServiceClient;

    @Override
    public RandomNumber subtractionAndMultiplicationWithNumber(RandomNumber number) {
        RandomNumber result = subtractNumbers(number, new RandomNumber());
        log.info("result of subtraction: " + result);
        return multiplyNumber(result);
    }

    private RandomNumber multiplyNumber(RandomNumber number){
        RandomNumber result = lowServiceClient.multiply(number);
        log.info("result of multiplication: " + result);
        return result;
    }

    private RandomNumber subtractNumbers(RandomNumber number1, RandomNumber number2){
        log.info("number: " + number1);
        log.info("newNumber: " + number2);
        if (number1.getNumber() > number2.getNumber()) {
            number1.setNumber(number1.getNumber() - number2.getNumber());
            return number1;
        }
        number2.setNumber(number2.getNumber() - number1.getNumber());
        return number2;
    }
}
