package org.example.model;

public class Driver extends Person{

    public Driver(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName()+ '\'' +
                '}';
    }
}
