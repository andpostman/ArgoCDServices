package com.andpostman.servicehigh.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.andpostman.servicehigh.feign.LowServiceClient;
import com.andpostman.servicehigh.feign.MediumServiceClient;
import com.andpostman.servicehigh.properties.RandomNumber;

@Service
@Slf4j
@RequiredArgsConstructor
public class ArithmeticServiceImpl implements ArithmeticService{

    private final LowServiceClient lowServiceClient;
    private final MediumServiceClient mediumServiceClient;

    @Override
    public String calculateNumbers(RandomNumber number) {
        log.info("body: " + number);
        double result = lowServiceClient.divide(number).getNumber() +
                mediumServiceClient.subtract(number).getNumber();
        number.setNumber(result);
        log.info("result: " + number);
        return number.toString();
    }
}
