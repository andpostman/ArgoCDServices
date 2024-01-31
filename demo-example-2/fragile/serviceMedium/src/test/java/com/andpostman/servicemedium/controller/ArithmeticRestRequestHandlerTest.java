package com.andpostman.servicemedium.controller;

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
import com.andpostman.servicemedium.properties.RandomNumber;
import com.andpostman.servicemedium.service.ArithmeticServiceImpl;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(RestRequestHandler.class)
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
public class ArithmeticRestRequestHandlerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private ArithmeticServiceImpl arithmeticService;

    @Test
    @DisplayName("Проверка когда тело и хедр заданы")
    public void whenRequestBodyAndRequestHeaderAreEmpty_thenReturn200() throws Exception {
        RandomNumber randomNumber = new RandomNumber();
        mockMvc.perform(post("/serviceMedium/subtract")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(randomNumber)))
                .andExpect(status().isOk());
    }
}
