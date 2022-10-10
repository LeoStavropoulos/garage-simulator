package org.example.service;

import org.example.dto.StaffDto;
import org.example.dto.VehicleDto;
import org.example.exception.*;

public interface IGarageService {

    /**
     * Inserts a {@link VehicleDto} object to the Garage.
     *
     * @param vehicleDto    to-be-inserted vehicle's DTO.
     * @throws InvalidNameException
     *          if Driver's or Staff's firstname or lastname is empty
     *          or contains digits or symbols.
     * @throws GarageFullException
     *          if there are no empty spots in the Garage.
     * @throws InvalidPlateNumberException
     *          if the plate number is not of the "XXX-0000" format.
     * @throws PlateNumAlreadyExistsException
     *          if the vehicle's plate number already exists in the Garage.
     */
    void entersGarage(VehicleDto vehicleDto) throws InvalidNameException, GarageFullException, InvalidPlateNumberException, PlateNumAlreadyExistsException;

    /**
     * Removes a {@link VehicleDto} object from the Garage.
     *
     * @param plateNum to-be-removed vehicle's plate number.
     * @return the vehicle's parking cost.
     * @throws InvalidPlateNumberException
     *          if the given plate number is not of the "XXX-0000" format.
     * @throws PlateNumNotFoundException
     *          if the vehicle's plate number does not exist in the Garage.
     */
    Double exitsGarage(String plateNum) throws InvalidPlateNumberException, PlateNumNotFoundException;

    /**
     * @return the number of empty parking spots.
     * @throws GarageFullException
     *          if there are no empty parking spots.
     */
    int getEmptySpotsNumber() throws GarageFullException;

    /**
     * @return the total amount of money earned.
     */
    Double getTotalMoneyEarned();

    /**
     * Shows a specific vehicle's staff details.
     *
     * @param plateNum the vehicle's plate number.
     * @return vehicle's {@link StaffDto}.
     * @throws InvalidPlateNumberException
     *          if the given plate number is not of the "XXX-0000" format.
     * @throws PlateNumNotFoundException
     *          if the vehicle's plate number does not exist in the Garage.
     */
    StaffDto getStaffDetails(String plateNum) throws InvalidPlateNumberException, PlateNumNotFoundException;
}
