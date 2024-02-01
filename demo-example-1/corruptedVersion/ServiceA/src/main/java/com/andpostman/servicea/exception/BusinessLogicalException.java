package com.andpostman.servicea.exception;

public class BusinessLogicalException extends RuntimeException{
    public BusinessLogicalException() {
        super("Logical Error");
    }
}
