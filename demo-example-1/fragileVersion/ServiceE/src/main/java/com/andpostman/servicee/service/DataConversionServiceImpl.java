package com.andpostman.servicee.service;

import com.andpostman.servicee.repository.RandomNumberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.andpostman.servicee.dto.RandomNumberDescription;
import com.andpostman.servicee.model.RandomNumber;

@Service("DataConversionServiceImplServiceEv3")
@Slf4j
@Transactional
@RequiredArgsConstructor
public class DataConversionServiceImpl implements DataConversionService{

    private final RandomNumberRepository repository;

    @Cacheable("getRandomNumberById")
    @Override
    public RandomNumberDescription getRandomNumberById(int id){
        if (repository.existsById(id)){
            return getRandomNumberFromDB(id);
        }
        else return createRandomNumberInDB();
    }

    @Override
    public RandomNumberDescription getRandomNumberFromDB(int id){
        log.info("Запись была найдена в БД ");
        RandomNumber randomNumberFromDB = repository.findRandomNumberById(id);
        return new RandomNumberDescription(randomNumberFromDB.getNumber());
    }

    @Override
    public RandomNumberDescription createRandomNumberInDB(){
        log.info("Записи на было найдено в БД ");
        RandomNumberDescription randomNumber = new RandomNumberDescription();
        repository.insertRandomNumber(randomNumber.getNumber());
        return randomNumber;
    }

    @Override
    public RandomNumberDescription responseFromDB() {
        RandomNumberDescription number = getRandomNumberById(1);
        log.info("ServiceE сгенерировал число: " + number);
        return number;
    }
}
