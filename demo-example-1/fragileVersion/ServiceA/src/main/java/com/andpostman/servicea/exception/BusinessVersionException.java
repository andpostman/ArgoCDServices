package com.andpostman.servicea.exception;

public class BusinessVersionException extends RuntimeException{
    public BusinessVersionException(String serviceName) {
        super("Получен ответ из другой версии "+serviceName.substring(
                serviceName.lastIndexOf("Service"),
                serviceName.lastIndexOf("\"")
        ));
    }
}
