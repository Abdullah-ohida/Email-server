package com.exceptions;

public class NameLengthException extends RuntimeException{
    public NameLengthException(String message) {
        super(message);
    }
}
