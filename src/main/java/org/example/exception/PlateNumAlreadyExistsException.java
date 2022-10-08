package org.example.exception;

public class PlateNumAlreadyExistsException extends Exception{
    private static final Long serialVersionUID = 1L;

    public PlateNumAlreadyExistsException(String plateNum) {
        super("A vehicle with plate number: " + plateNum + " already exists in the garage!");
    }
}
