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
 *  Converts a DTO Object to a Model Object
 */
public class DtoToModelConverter {

    private DtoToModelConverter() {}

    public static Driver toModel(DriverDto dto) {
        if (dto == null) {
            return null;
        }

        return new Driver(dto.getFirstName(), dto.getLastName(), dto.getId());
    }

    public static Staff toModel(StaffDto dto) {
        if (dto == null) {
            return null;
        }

        return new Staff(dto.getFirstName(), dto.getLastName(), dto.getId());
    }

    public static Car toModel(CarDto dto) {
        if (dto == null) {
            return null;
        }

        return new Car(dto.getId(), toModel(dto.getDriver()), toModel(dto.getStaff()), dto.getPlateNum(), dto.getCharge(), dto.getEntranceDateTime());
    }

    public static Motorcycle toModel(MotorcycleDto dto) {
        if (dto == null) {
            return null;
        }

        return new Motorcycle(dto.getId(), toModel(dto.getDriver()), toModel(dto.getStaff()), dto.getPlateNum(), dto.getCharge(), dto.getEntranceDateTime());
    }
}
