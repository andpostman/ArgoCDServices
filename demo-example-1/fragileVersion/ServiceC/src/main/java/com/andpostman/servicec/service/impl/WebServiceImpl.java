package com.andpostman.servicec.service.impl;

import com.andpostman.servicec.exception.BusinessConnectionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import com.andpostman.servicec.config.WebClientConfig;
import com.andpostman.servicec.dto.RandomNumber;
import com.andpostman.servicec.service.WebService;

@Service("WebServiceImplServiceCv3")
@RequiredArgsConstructor
@Slf4j
public class WebServiceImpl implements WebService {

    private final WebClientConfig servicesConfig;

    @Override
    public Mono<RandomNumber> getResponseFromServiceE() {
        log.info("Запрос на получение RandomNumber из ServiceE");

        return servicesConfig.callServiceE().get()
                .uri("/get")
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(RandomNumber.class))
                .onErrorResume(error -> Mono.error(new BusinessConnectionException("ServiceE "+error.getMessage())));
    }

    @Override
    public Mono<RandomNumber> getResponseFromServiceD() {
        log.info("Запрос на получение RandomNumber из ServiceD");
        return servicesConfig.callServiceD().get()
                .uri("/get")
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(RandomNumber.class))
                .onErrorResume(error -> Mono.error(new BusinessConnectionException("ServiceD "+error.getMessage())));
    }
}
