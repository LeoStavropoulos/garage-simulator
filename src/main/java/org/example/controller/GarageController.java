package org.example.controller;

import org.example.dto.*;
import org.example.exception.*;
import org.example.service.GarageServiceImpl;
import org.example.service.IGarageService;

public class GarageController {

    IGarageService service = new GarageServiceImpl();

    public void entersGarage(String... fields) throws InvalidNameException, InvalidPlateNumberException, PlateNumAlreadyExistsException, GarageFullException {
        DriverDto driverDto = new DriverDto(fields[1], fields[2]);
        StaffDto staffDto = new StaffDto(fields[3], fields[4]);
        VehicleDto vehicleDto = (fields[0].equals("1")) ?
                new CarDto(driverDto, staffDto, fields[5]) :
                new MotorcycleDto(driverDto, staffDto, fields[5]);

        service.entersGarage(vehicleDto);
    }

    public Double exitsGarage(String plateNum) throws PlateNumNotFoundException, InvalidPlateNumberException {
        return service.exitsGarage(plateNum);
    }

    public int getEmptySpotsNumber() throws GarageFullException{
        return service.getEmptySpotsNumber();
    }

    public Double getTotalMoneyEarned(){
        return service.getTotalMoneyEarned();
    }

    public String getStaffDetails(String plateNum) throws PlateNumNotFoundException, InvalidPlateNumberException {
        return service.getStaffDetails(plateNum).toString();
    }
}
