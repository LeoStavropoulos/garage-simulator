package org.example.dto;

public class StaffDto extends PersonDto{
    public StaffDto(String firstName, String lastName) {
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
