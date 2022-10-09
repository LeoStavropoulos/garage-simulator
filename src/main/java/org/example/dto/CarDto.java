package org.example.dto;

import java.time.LocalDateTime;

public class CarDto extends VehicleDto{
    public CarDto(DriverDto driver, StaffDto staff, String plateNum, Double charge, LocalDateTime entranceDateTime) {
        super(driver, staff, plateNum, charge, entranceDateTime);
    }

    @Override
    public String toString() {
        return "Car{" +
                ", plateNum='" + getPlateNum() + '\'' +
                "driver=" + getDriver() +
                ", staff=" + getStaff() +
                ", charge=" + getCharge() +
                ", entranceDateTime=" + getEntranceDateTime() +
                '}';
    }
}
