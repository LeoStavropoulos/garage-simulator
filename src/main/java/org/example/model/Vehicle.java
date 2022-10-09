package org.example.model;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Vehicle {

    private Driver driver;

    private Staff staff;

    private String plateNum;

    private Double charge;

    private LocalDateTime entranceDateTime;

    protected Vehicle(Driver driver, Staff staff, String plateNum, Double charge, LocalDateTime entranceDateTime) {
        this.driver = driver;
        this.staff = staff;
        this.plateNum = plateNum;
        this.charge = charge;
        this.entranceDateTime = entranceDateTime;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public String getPlateNum() {
        return plateNum;
    }

    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }

    public Double getCharge() {
        return charge;
    }

    public void setCharge(Double charge) {
        this.charge = charge;
    }

    public LocalDateTime getEntranceDateTime() {
        return entranceDateTime;
    }

    public void setEntranceDateTime(LocalDateTime entranceDateTime) {
        this.entranceDateTime = entranceDateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return getPlateNum().equals(vehicle.getPlateNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlateNum());
    }
}
