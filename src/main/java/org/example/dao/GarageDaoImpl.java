package org.example.dao;

import org.example.model.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class GarageDaoImpl implements IGarageDao{

    private static final Integer GARAGE_CAPACITY = 200;
    private static final Integer MAP_SIZE = (int) Math.round(GARAGE_CAPACITY * 0.75);
    private static final GarageDaoImpl dao = new GarageDaoImpl();
    private static final Map<String, Vehicle> garage = new HashMap<>(MAP_SIZE);

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
    public void addMoney(Double amount) {
        totalMoney += amount;
    }

    @Override
    public Double getTotalMoneyEarned() {
        return totalMoney;
    }

    @Override
    public Integer getVacantSpotsNumber() {
        return GARAGE_CAPACITY - garage.size();
    }
}
