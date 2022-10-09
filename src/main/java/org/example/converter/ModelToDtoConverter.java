package org.example.converter;

import org.example.dto.CarDto;
import org.example.dto.DriverDto;
import org.example.dto.MotorcycleDto;
import org.example.dto.StaffDto;
import org.example.model.Car;
import org.example.model.Driver;
import org.example.model.Motorcycle;
import org.example.model.Staff;

/**
 *  Converts a Model Object to a DTO Object
 */
public class ModelToDtoConverter {

    private ModelToDtoConverter() {}

    public static DriverDto toDto(Driver model) {
        if (model == null) {
            return null;
        }

        return new DriverDto(model.getFirstName(), model.getLastName());
    }

    public static StaffDto toDto(Staff model) {
        if (model == null) {
            return null;
        }

        return new StaffDto(model.getFirstName(), model.getLastName());
    }

    public static CarDto toDto(Car model) {
        if (model == null) {
            return null;
        }

        return new CarDto(toDto(model.getDriver()), toDto(model.getStaff()), model.getPlateNum(), model.getCharge(), model.getEntranceDateTime());
    }

    public static MotorcycleDto toDto(Motorcycle model) {
        if (model == null) {
            return null;
        }

        return new MotorcycleDto(toDto(model.getDriver()), toDto(model.getStaff()), model.getPlateNum(), model.getCharge(), model.getEntranceDateTime());
    }
}
