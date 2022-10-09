package org.example.service;

import org.example.dto.StaffDto;
import org.example.dto.VehicleDto;
import org.example.exception.*;

public interface IGarageService {

    void entersGarage(VehicleDto vehicleDto) throws InvalidNameException, GarageFullException, InvalidPlateNumberException, PlateNumAlreadyExistsException;

    Double exitsGarage(String plateNum) throws InvalidPlateNumberException, PlateNumNotFoundException;

    int getEmptySpotsNumber() throws GarageFullException;

    Double getTotalMoneyEarned();

    StaffDto getStaffDetails(String plateNum) throws InvalidPlateNumberException, PlateNumNotFoundException;
}
