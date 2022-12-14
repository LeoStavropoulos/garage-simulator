package org.example.dto;

import org.example.model.Driver;
import org.example.model.Staff;

import java.time.LocalDateTime;

public class MotorcycleDto extends VehicleDto{
    public MotorcycleDto(DriverDto driver, StaffDto staff, String plateNum, Double charge, LocalDateTime entranceDateTime) {
        super(driver, staff, plateNum, charge, entranceDateTime);
    }

    public MotorcycleDto(DriverDto driver, StaffDto staff, String plateNum) {
        super(driver, staff, plateNum);
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
