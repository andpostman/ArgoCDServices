package com.andpostman.servicee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.andpostman.servicee.model.RandomNumber;

public interface RandomNumberRepository extends JpaRepository<RandomNumber, Long> {


    @Query(nativeQuery = true, value = "select * from demo.random_numbers number where number.id = :id")
    RandomNumber findRandomNumberById(int id);

    @Query(nativeQuery = true, value = "select exists(select * from demo.random_numbers number where number.id = 1)")
    boolean existsById(int id);

    @Modifying
    @Query(nativeQuery = true, value = "insert into demo.random_numbers(number)" +
            " values (:number)")
    void insertRandomNumber(@Param("number") int number);


}


