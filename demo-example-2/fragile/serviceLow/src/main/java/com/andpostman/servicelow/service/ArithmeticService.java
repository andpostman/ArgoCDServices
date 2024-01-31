package com.andpostman.servicelow.service;

import com.andpostman.servicelow.properties.RandomNumber;

public interface ArithmeticService {
    RandomNumber getMultiplicationWithNumber(RandomNumber number);
    RandomNumber getDivisionWithNumber(RandomNumber number);
}
