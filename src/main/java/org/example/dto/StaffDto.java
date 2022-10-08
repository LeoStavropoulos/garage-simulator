package org.example.dto;

public class StaffDto extends PersonDto{
    public StaffDto(String firstName, String lastName, Long id) {
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
