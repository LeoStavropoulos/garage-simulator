package org.example.converter;

import org.example.dto.*;
import org.example.model.*;

/**
 *  Converts a DTO Object to a Model Object
 */
public class DtoToModelConverter {

    private DtoToModelConverter() {}

    public static Driver toModel(DriverDto dto) {
        if (dto == null) {
            return null;
        }

        return new Driver(dto.getFirstName(), dto.getLastName());
    }

    public static Staff toModel(StaffDto dto) {
        if (dto == null) {
            return null;
        }

        return new Staff(dto.getFirstName(), dto.getLastName());
    }

    public static Vehicle toModel(VehicleDto dto) {
        if (dto == null) {
            return null;
        }

        return (dto instanceof CarDto) ?
                new Car(toModel(dto.getDriver()), toModel(dto.getStaff()), dto.getPlateNum(), dto.getCharge(), dto.getEntranceDateTime()):
                new Motorcycle(toModel(dto.getDriver()), toModel(dto.getStaff()), dto.getPlateNum(), dto.getCharge(), dto.getEntranceDateTime());

    }
}
