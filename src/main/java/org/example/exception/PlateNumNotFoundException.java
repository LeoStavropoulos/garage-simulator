package org.example.exception;

public class PlateNumNotFoundException extends Exception{
    private static final Long serialVersionUID = 1L;

    public PlateNumNotFoundException(String plateNum) {
        super("There are no vehicles having a plate number: " + plateNum);
    }
}
