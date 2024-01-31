package com.andpostman.servicelow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import com.andpostman.servicelow.controller.RestRequestHandler;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class ServiceLowApplicationTests {

    @InjectMocks
    RestRequestHandler restRequestHandler;

    @Test
    @DisplayName("Проверка ответа запроса")
    void contextLoads() {
        assertThat(restRequestHandler.report()).contains("ready");
    }

}
