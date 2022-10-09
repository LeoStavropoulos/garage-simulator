package org.example.dao;

import org.example.exception.GarageFullException;
import org.example.model.Driver;
import org.example.model.Vehicle;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GarageDaoImpl implements IGarageDao{

    private static final Integer GARAGE_CAPACITY = 200;
    private static final Integer MAP_SIZE = (int) Math.round(GARAGE_CAPACITY * 0.75);
    private static final GarageDaoImpl dao = new GarageDaoImpl();
    private static final Map<String, Vehicle> garage = new HashMap<>(MAP_SIZE);

    private static final Set<Driver> drivers = new HashSet<>();

    private Double totalMoney = 0.0;

    private GarageDaoImpl() {}

    public static GarageDaoImpl getInstance() {
        return dao;
    }

    @Override
    public void insertVehicle(Vehicle vehicle) {
        garage.put(vehicle.getPlateNum(), vehicle);
    }

    @Override
    public void removeVehicle(String plateNum) {
        garage.remove(plateNum);
    }

    @Override
    public Vehicle findVehicleByPlateNumber(String plateNum) {
        return garage.get(plateNum);
    }

    @Override
    public Boolean findIfDriverExists(Driver driver) {
        for (Map.Entry<String, Vehicle> entry : garage.entrySet()) {
            Vehicle v = entry.getValue();
            if (v.getDriver() == driver) return true;
        }
        return false;
    }

    @Override
    public Map<String, Vehicle> getGarage() {
        return garage;
    }

    @Override
    public void addMoney(Double amount) {
        totalMoney += amount;
    }

    @Override
    public Double getTotalMoneyEarned() {
        return totalMoney;
    }

    @Override
    public Integer getVacantSpotsNumber() throws GarageFullException {
        if (garage.size() == GARAGE_CAPACITY) {
            throw new GarageFullException();
        }
        return GARAGE_CAPACITY - garage.size();
    }

    @Override
    public void addDriver(Driver driver) {
        drivers.add(driver);
    }

    @Override
    public void removeDriver(Driver driver) {
        drivers.remove(driver);
    }

    @Override
    public Set<Driver> getDrivers() {
        return drivers;
    }
}
