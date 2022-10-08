package org.example.exception;

public class InvalidPlateNumberException extends Exception{
    private static final Long serialVersionUID = 1L;

    public InvalidPlateNumberException() {
        super("Invalid plate number! It should not be empty and must be of the following format: XXX-1234");
    }
}
