package org.example.dao;

import org.example.exception.GarageFullException;
import org.example.model.Driver;
import org.example.model.Vehicle;

import java.util.Map;
import java.util.Set;

public interface IGarageDao {

    /**
     * Inserts a {@link Vehicle} object in the Garage.
     * @param vehicle   the vehicle ({@link org.example.model.Car} or
     *                  {@link  org.example.model.Motorcycle}) to be inserted.
     */
    void insertVehicle(Vehicle vehicle);

    /**
     * Removes a {@link Vehicle} object from the Garage.
     * @param plateNum to-be-removed {@link Vehicle}'s plate number.
     */
    void removeVehicle(String plateNum);

    /**
     * Finds a {@link Vehicle} object by its plate number.
     * @param plateNum Plate number to look for.
     * @return {@link Vehicle} object or null if the object is not found.
     */
    Vehicle findVehicleByPlateNumber(String plateNum);

    /**
     * Checks if a {@link Driver} object exists in the Garage.
     * @param driver {@link Driver} object to look for
     * @return true if the {@link Driver} exists, otherwise false.
     */
    Boolean findIfDriverExists(Driver driver);

    /**
     * @return DAO's Garage {@link Map}.
     */
    Map<String, Vehicle> getGarage();

    /**
     * Adds an amount of money to the sum.
     * @param amount money to be added.
     */
    void addMoney(Double amount);

    /**
     * @return Total money earned
     */
    Double getTotalMoneyEarned();

    /**
     * @return number of empty parking spots.
     * @throws GarageFullException
     */
    Integer getVacantSpotsNumber() throws GarageFullException;

    /**
     * Adds a {@link Driver} object to the drivers' {@link Set}.
     * @param driver {@link Driver} object to be added.
     */
    void addDriver (Driver driver);

    /**
     * Removes a {@link Driver} object from the drivers' {@link Set}.
     * @param driver {@link Driver} object to be removed.
     */
    void removeDriver (Driver driver);

    /**
     * @return a {@link Set} of {@link Driver} objects
     */
    Set<Driver> getDrivers();
}
