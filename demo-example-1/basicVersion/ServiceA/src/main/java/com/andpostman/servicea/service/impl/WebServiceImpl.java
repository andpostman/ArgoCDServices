package com.andpostman.servicea.service.impl;

import com.andpostman.servicea.exception.BusinessConnectionException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientRequestException;
import reactor.core.publisher.Mono;
import com.andpostman.servicea.config.WebClientConfig;
import com.andpostman.servicea.dto.RandomNumber;
import com.andpostman.servicea.service.WebService;

@Service("WebServiceImplServiceAv1")
@RequiredArgsConstructor
@Slf4j
public class WebServiceImpl implements WebService {

    private final WebClientConfig servicesConfig;

    @Override
    public void postResponseFromServiceB(){
        servicesConfig.callServiceB().post()
                .uri("/prepare")
                .exchangeToMono(clientResponse -> Mono.empty())
                .onErrorResume(error -> Mono.error(new BusinessConnectionException("ServiceB "+error.getMessage())))
                .block();
    }

    @Override
    public Mono<RandomNumber> getResponseFromServiceB() {
        log.info("Запрос на получение RandomNumber из ServiceB");
        postResponseFromServiceB();
        return servicesConfig.callServiceB().get()
                .uri("/get")
                .exchangeToMono(clientResponse -> clientResponse.bodyToMono(RandomNumber.class))
                .onErrorResume(error -> Mono.error(new BusinessConnectionException("ServiceB "+error.getMessage())));
    }

    @Override
    public Mono<RandomNumber> getResponseFromServiceC() {
        log.info("Запрос на получение RandomNumber из ServiceC");
        return servicesConfig.callServiceC().post()
                .uri("/calc")
                .exchangeToMono(clientResponse -> {
                    if (clientResponse.statusCode().is5xxServerError()) {
                        return clientResponse.createException().flatMap(e -> Mono.error(new BusinessConnectionException(e.getResponseBodyAsString())));
                    }
                    return clientResponse.bodyToMono(RandomNumber.class);
                })
                .doOnError(WebClientRequestException.class, e -> {
                    throw new BusinessConnectionException("ServiceC "+ e.getMessage());
                });
    }
}
