package org.example.dao;

import org.example.exception.GarageFullException;
import org.example.model.Driver;
import org.example.model.Vehicle;

import java.util.Map;
import java.util.Set;

public interface IGarageDao {

    void insertVehicle(Vehicle vehicle);

    void removeVehicle(String plateNum);

    Vehicle findVehicleByPlateNumber(String plateNum);

    Boolean findIfDriverExists(Driver driver);

    Map<String, Vehicle> getGarage();

    void addMoney(Double amount);

    Double getTotalMoneyEarned();

    Integer getVacantSpotsNumber() throws GarageFullException;

    void addDriver (Driver driver);

    void removeDriver (Driver driver);

    Set<Driver> getDrivers();
}
