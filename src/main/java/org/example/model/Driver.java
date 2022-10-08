package org.example.model;

public class Driver extends Person{

    public Driver(String firstName, String lastName, Long id) {
        super(firstName, lastName, id);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "ID='" + getId() + '\'' +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName()+ '\'' +
                '}';
    }
}
