package org.example.model;

import java.time.LocalDateTime;

public class Motorcycle extends Vehicle{
    public Motorcycle(Driver driver, Staff staff, String plateNum, Double charge, LocalDateTime entranceDateTime) {
        super(driver, staff, plateNum, charge, entranceDateTime);
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                ", plateNum='" + getPlateNum() + '\'' +
                "driver=" + getDriver() +
                ", staff=" + getStaff() +
                ", charge=" + getCharge() +
                ", entranceDateTime=" + getEntranceDateTime() +
                '}';
    }
}
