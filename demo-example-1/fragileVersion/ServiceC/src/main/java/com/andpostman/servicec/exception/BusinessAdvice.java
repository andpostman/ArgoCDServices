package com.andpostman.servicec.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class BusinessAdvice {

    @ResponseBody
    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(BusinessConnectionException.class)
    public BusinessConnectionException emptyFieldsHandler(BusinessConnectionException exception){
        log.error(exception.getMessage());
        return exception;
    }

    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(BusinessVersionException.class)
    public BusinessVersionException emptyFieldsHandler(BusinessVersionException exception){
        log.error(exception.getMessage());
        return exception;
    }
}
