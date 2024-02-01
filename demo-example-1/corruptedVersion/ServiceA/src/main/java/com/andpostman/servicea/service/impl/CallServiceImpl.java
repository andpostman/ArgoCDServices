package com.andpostman.servicea.service.impl;

import com.andpostman.servicea.dto.RandomNumber;
import com.andpostman.servicea.dto.WorkTime;
import com.andpostman.servicea.exception.BusinessLogicalException;
import com.andpostman.servicea.service.CallService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.Objects;
import java.util.SplittableRandom;

@Service("CallServiceImplServiceAv2")
@RequiredArgsConstructor
@Slf4j
public class CallServiceImpl implements CallService {

    private final WebServiceImpl webService;

    @Override
    public Flux<Integer> calcSumOfServicesNumbers() {
        log.info("Получение результата из сервисов");
        return Flux.zip(webService.getResponseFromServiceB(), webService.getResponseFromServiceC(), (b,c) -> b.getNumber() + c.getNumber());
    }


    @Override
    public void checkForLogicalError(WorkTime workTime){
        log.info("Прошедшее время после старта приложения: " + workTime.getTimeDifference());
        if (hasLogicalError(workTime.getTimeDifference())) {
            throw new BusinessLogicalException();
        }
    }

    @Override
    public String responseFromServices() {
        RandomNumber calcResult = new RandomNumber();
        calcResult.setNumber(Integer.parseInt(
                Objects.requireNonNull(
                        calcSumOfServicesNumbers().blockLast()).toString()
        ));
        log.info(calcResult.toString());
        return calcResult.toString();
    }

    private boolean hasLogicalError(long duration) {
        if (WorkTime.getInstance().getTimeDifference() > 60) {
            SplittableRandom random = new SplittableRandom();
            if (duration < 120) {
                return random.nextInt(1, 101) == 100;
            } else {
                return random.nextInt(1, 4) == 3;
            }
        }
        return false;
    }

}
