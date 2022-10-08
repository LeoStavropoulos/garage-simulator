package org.example.model;

import java.time.LocalDateTime;

public class Car extends Vehicle{
    public Car(Long id, Driver driver, Staff staff, String plateNum, Double charge, LocalDateTime entranceDateTime) {
        super(id, driver, staff, plateNum, charge, entranceDateTime);
    }

    @Override
    public String toString() {
        return "Car{" +
                ", ID='" + getId() + '\'' +
                ", plateNum='" + getPlateNum() + '\'' +
                "driver=" + getDriver() +
                ", staff=" + getStaff() +
                ", charge=" + getCharge() +
                ", entranceDateTime=" + getEntranceDateTime() +
                '}';
    }
}
