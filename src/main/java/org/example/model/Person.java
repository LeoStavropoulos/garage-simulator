package org.example.model;

public abstract class Person extends AbstractEntity{
    private String firstName;
    private String lastName;

    protected Person(String firstName, String lastName, Long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setId(id);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}