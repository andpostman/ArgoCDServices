package com.andpostman.servicehigh.controller;

import com.andpostman.servicehigh.service.ArithmeticServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestRequestHandler.class)
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class ArithmeticRestControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ArithmeticServiceImpl arithmeticService;

    @Test
    @DisplayName("Проверка когда тело и хедр пустые")
    public void whenRequestBodyAndRequestHeaderAreEmpty_thenReturns200() throws Exception {
        mockMvc.perform(post("/serviceHigh/calculate"))
                .andExpect(status().is4xxClientError());
    }

    @Test
    @DisplayName("Проверка когда тело и хедр заданы")
    public void whenRequestBodyAndRequestHeaderExpected_thenReturns200() throws Exception {
        mockMvc.perform(post("/serviceHigh/calculate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"number\":1.5}"))
                .andExpect(status().is2xxSuccessful());
    }

}
