package com.andpostman.servicehigh;

import com.andpostman.servicehigh.controller.RestRequestHandler;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ServiceHighApplicationTests {

    @InjectMocks
    RestRequestHandler restRequestHandler;

    @Test
    @DisplayName("Проверка ответа запроса")
    void contextLoads() {
        assertThat(restRequestHandler.report()).contains("ready");
    }

}
