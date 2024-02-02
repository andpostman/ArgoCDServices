package com.andpostman.servicea.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import com.andpostman.servicea.dto.RandomNumber;
import com.andpostman.servicea.exception.BusinessVersionException;
import com.andpostman.servicea.service.CallService;
import java.util.Objects;

@Service("CallServiceImplServiceAv3")
@RequiredArgsConstructor
@Slf4j
public class CallServiceImpl implements CallService {

    private final WebServiceImpl webService;

    @Override
    public Flux<Integer> calcSumOfServicesNumbers() {
        log.info("Получение результата из сервисов");
        return Flux.zip(webService.getResponseFromServiceB(), webService.getResponseFromServiceC(),
                (b,c) -> {
                    if (b.getTime() == null)
                        throw new BusinessVersionException("ServiceB\"");
                    if (c.getTime() == null)
                        throw new BusinessVersionException("ServiceC\"");
                    return b.getNumber() + c.getNumber();
                });
    }

    @Override
    public String responseFromServices() {
        RandomNumber calcResult = new RandomNumber();
        calcResult.setNumber(Integer.parseInt(
                Objects.requireNonNull(
                        calcSumOfServicesNumbers().blockLast()).toString()
        ));
        calcResult.setTime();
        log.info(calcResult.toString());
        return calcResult.toString();
    }
}