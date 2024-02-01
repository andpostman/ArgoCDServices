package com.andpostman.servicec.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import com.andpostman.servicec.dto.RandomNumber;
import com.andpostman.servicec.service.CallService;
import java.util.Objects;

@Service("CallServiceImplServiceCv1")
@RequiredArgsConstructor
@Slf4j
public class CallServiceImpl implements CallService {

    private final WebServiceImpl webService;

    @Override
    public Flux<Integer> calcSumOfServicesNumbers() {
        log.info("Получение результата из сервисов");
        return Flux.zip(webService.getResponseFromServiceE(), webService.getResponseFromServiceD(), (d, e) -> d.getNumber() + e.getNumber());
    }

    @Override
    public RandomNumber responseFromServices() {
        RandomNumber calcResult = new RandomNumber();
        calcResult.setNumber(Integer.parseInt(
                Objects.requireNonNull(
                        calcSumOfServicesNumbers().blockLast()).toString()
        ));
        log.info(calcResult.toString());
        return calcResult;
    }

}
