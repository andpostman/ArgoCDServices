package com.andpostman.servicehigh.service;

import com.andpostman.servicehigh.feign.LowServiceClient;
import com.andpostman.servicehigh.feign.MediumServiceClient;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import com.andpostman.servicehigh.properties.RandomNumber;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArithmeticServiceImplTest {

    @Mock
    LowServiceClient lowServiceClient;

    @Mock
    MediumServiceClient mediumServiceClient;

    @InjectMocks
    ArithmeticServiceImpl service;

    @Test
    @DisplayName("Проверка сервиса при получении числа")
    public void whenNumberIsEmpty_thenReturnStringNumber(){
        when(lowServiceClient.divide(any(RandomNumber.class))).then((Answer<RandomNumber>) invocationOnMock -> {
            RandomNumber randomNumber = new RandomNumber();
            randomNumber.setNumber(
                    randomNumber.getNumber() / new RandomNumber().getNumber());
            return randomNumber;
        });

        when(mediumServiceClient.subtract(any(RandomNumber.class))).then((Answer<RandomNumber>) invocationOnMock -> {

            RandomNumber randomNumber = new RandomNumber();
            RandomNumber newNumber = new RandomNumber();
            if (newNumber.getNumber() > randomNumber.getNumber()){
                randomNumber.setNumber(newNumber.getNumber() - randomNumber.getNumber());
                return randomNumber;
            }
            randomNumber.setNumber(randomNumber.getNumber() - newNumber.getNumber());
            return randomNumber;
        });
        assertThat(service.calculateNumbers(new RandomNumber(11.2))).contains("Result:");
    }
}
