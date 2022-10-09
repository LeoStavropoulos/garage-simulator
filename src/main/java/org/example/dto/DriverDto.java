package org.example.dto;

public class DriverDto extends PersonDto{
    public DriverDto(String firstName, String lastName) {
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
