package com.andpostman.servicemedium.service;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import com.andpostman.servicemedium.feign.LowServiceClient;
import com.andpostman.servicemedium.properties.RandomNumber;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArithmeticServiceImplTest {

    @Mock
    LowServiceClient lowServiceClient;

    @InjectMocks
    ArithmeticServiceImpl service;

    @Test
    @DisplayName("Проверка что умножение и вычитание вернет RandomNumber")
    public void whenSubtractAndMultiply_thenReturnRandomNumber(){
        when(lowServiceClient.multiply(any(RandomNumber.class))).then((Answer<RandomNumber>) invocationOnMock -> {
            RandomNumber randomNumber = new RandomNumber();
            randomNumber.setNumber(
                    randomNumber.getNumber() * new RandomNumber().getNumber());
            return randomNumber;
        });

        assertThat(service.subtractionAndMultiplicationWithNumber(new RandomNumber())).isInstanceOf(RandomNumber.class);
    }
}
