package org.example.model;

public class Staff extends Person{

    public Staff(String firstName, String lastName, Long id) {
        super(firstName, lastName, id);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "ID='" + getId() + '\'' +
                "firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName()+ '\'' +
                '}';
    }
}
