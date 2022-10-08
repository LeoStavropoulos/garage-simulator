package org.example.dao;

import org.example.model.Vehicle;

public interface IGarageDao {

    void insertVehicle(Vehicle vehicle);

    void removeVehicle(String plateNum);

    Vehicle findVehicleByPlateNumber(String plateNum);

    void addMoney(Double amount);

    Double getTotalMoneyEarned();

    Integer getVacantSpotsNumber();
}
