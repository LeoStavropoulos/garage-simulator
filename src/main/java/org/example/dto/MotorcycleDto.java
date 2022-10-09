package org.example.dto;

import org.example.model.Driver;
import org.example.model.Staff;

import java.time.LocalDateTime;

public class MotorcycleDto extends VehicleDto{
    public MotorcycleDto(Long id, DriverDto driver, StaffDto staff, String plateNum, Double charge, LocalDateTime entranceDateTime) {
        super(id, driver, staff, plateNum, charge, entranceDateTime);
    }

    @Override
    public String toString() {
        return "Motorcycle{" +
                ", ID='" + getId() + '\'' +
                ", plateNum='" + getPlateNum() + '\'' +
                "driver=" + getDriver() +
                ", staff=" + getStaff() +
                ", charge=" + getCharge() +
                ", entranceDateTime=" + getEntranceDateTime() +
                '}';
    }
}
