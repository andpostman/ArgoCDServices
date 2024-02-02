package com.andpostman.servicec.service.impl;

import com.andpostman.servicec.exception.BusinessVersionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import com.andpostman.servicec.dto.RandomNumber;
import com.andpostman.servicec.service.CallService;

import java.util.Objects;

@Service("CallServiceImplServiceCv3")
@RequiredArgsConstructor
@Slf4j
public class CallServiceImpl implements CallService {

    private final WebServiceImpl webService;

    @Override
    public Flux<Integer> calcSumOfServicesNumbers() {
        log.info("Получение результата из сервисов");
        return Flux.zip(webService.getResponseFromServiceD(), webService.getResponseFromServiceE(),
                (d,e) -> {
                    if (e.getTime() == null)
                        throw new BusinessVersionException("ServiceE");
                    return d.getNumber() + e.getNumber();
                });
    }

    @Override
    public RandomNumber responseFromServices() {
        RandomNumber calcResult = new RandomNumber();
        calcResult.setNumber(Integer.parseInt(
                Objects.requireNonNull(
                        calcSumOfServicesNumbers().blockLast()).toString()
        ));
        calcResult.setTime();
        log.info(calcResult.toString());
        return calcResult;
    }

}
