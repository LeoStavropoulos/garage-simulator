package org.example.exception;

public class InvalidNameException extends Exception{
    private static final Long serialVersionUID = 1L;

    public InvalidNameException(String field) {
        super("Invalid " + field + "! It should not be empty or contain numbers, symbols or special characters.");
    }
}
