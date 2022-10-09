package org.example.model;

public class Staff extends Person{

    public Staff(String firstName, String lastName) {
        super(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName()+ '\'' +
                '}';
    }
}
