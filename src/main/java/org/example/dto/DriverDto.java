package org.example.dto;

public class DriverDto extends PersonDto{
    protected DriverDto(String firstName, String lastName, Long id) {
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
