package com.andpostman.servicemedium;

import com.andpostman.servicemedium.controller.RestRequestHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ServiceMediumApplicationTests {

    @InjectMocks
    RestRequestHandler restRequest;

    @Test
    @DisplayName("Проверка ответа запроса")
    void contextLoads() {
        assertThat(restRequest.report()).contains("ready");
    }

}
