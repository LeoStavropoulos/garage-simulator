package org.example.converter;

import org.example.dto.*;
import org.example.model.*;

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

    public static VehicleDto toDto(Vehicle model) {
        if (model == null) {
            return null;
        }

        return (model instanceof Car) ?
                new CarDto(toDto(model.getDriver()), toDto(model.getStaff()), model.getPlateNum(), model.getCharge(), model.getEntranceDateTime()):
                new MotorcycleDto(toDto(model.getDriver()), toDto(model.getStaff()), model.getPlateNum(), model.getCharge(), model.getEntranceDateTime());
    }
}
