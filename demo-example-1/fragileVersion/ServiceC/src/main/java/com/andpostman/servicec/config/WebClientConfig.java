package com.andpostman.servicec.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Value("${web-client.service-d.base-url}")
    private String serviceHostD;
    @Value("${web-client.service-e.base-url}")
    private String serviceHostE;

    @Bean
    public WebClient callServiceD() {
        return WebClient.builder()
                .baseUrl(serviceHostD)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    public WebClient callServiceE() {

        return WebClient.builder()
                .baseUrl(serviceHostE)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
