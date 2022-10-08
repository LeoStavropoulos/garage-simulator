package org.example.exception;

public class GarageFullException extends Exception{
    private static final Long serialVersionUID = 1L;

    public GarageFullException() {
        super("No spots available in the Garage!");
    }
}
