package com.andpostman.servicec.exception;

public class BusinessVersionException extends RuntimeException{
    public BusinessVersionException(String serviceName) {
        super("Получен ответ из другой версии "+serviceName);
    }
}
