package com.andpostman.servicelow.service;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import com.andpostman.servicelow.properties.RandomNumber;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class ArithmeticServiceImplTest {

    @InjectMocks
    ArithmeticServiceImpl service;

    @Test
    @DisplayName("Проверка что умножение вернет RandomNumber")
    public void whenMultiplyNumber_thenReturnRandomNumber(){
        assertThat(service.getMultiplicationWithNumber(new RandomNumber())).isInstanceOf(RandomNumber.class);
    }

    @Test
    @DisplayName("Проверка что деление вернет RandomNumber")
    public void whenDivideNumber_thenReturnRandomNumber(){
        assertThat(service.getDivisionWithNumber(new RandomNumber())).isInstanceOf(RandomNumber.class);
    }

}
