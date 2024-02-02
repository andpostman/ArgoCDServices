package com.andpostman.servicee.service;

import com.andpostman.servicee.dto.RandomNumberDescription;

public interface DataConversionService {

    RandomNumberDescription getRandomNumberById(int id);

    RandomNumberDescription getRandomNumberFromDB(int id);

    RandomNumberDescription createRandomNumberInDB();

    RandomNumberDescription responseFromDB();
}