package com.andpostman.servicea.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${web-client.service-b.base-url}")
    private String serviceHostB;
    @Value("${web-client.service-c.base-url}")
    private String serviceHostC;

    @Bean
    public WebClient callServiceC() {
        return WebClient.builder()
                .baseUrl(serviceHostC)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    public WebClient callServiceB() {

        return WebClient.builder()
                .baseUrl(serviceHostB)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

}
