package com.andpostman.servicea.exception;

public class BusinessConnectionException extends RuntimeException{
    public BusinessConnectionException(String message) {
        super(message.substring(message.lastIndexOf("Service"),message.lastIndexOf(";")));
    }
}
