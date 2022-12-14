package org.example.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public abstract class VehicleDto {
    private DriverDto driver;

    private StaffDto staff;

    private String plateNum;

    private Double charge;

    private LocalDateTime entranceDateTime;

    protected VehicleDto(DriverDto driver, StaffDto staff, String plateNum, Double charge, LocalDateTime entranceDateTime) {
        this.driver = driver;
        this.staff = staff;
        this.plateNum = plateNum;
        this.charge = charge;
        this.entranceDateTime = entranceDateTime;
    }

    public VehicleDto(DriverDto driver, StaffDto staff, String plateNum) {
        this.driver = driver;
        this.staff = staff;
        this.plateNum = plateNum;
    }

    public DriverDto getDriver() {
        return driver;
    }

    public void setDriver(DriverDto driver) {
        this.driver = driver;
    }

    public StaffDto getStaff() {
        return staff;
    }

    public void setStaff(StaffDto staff) {
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
        VehicleDto that = (VehicleDto) o;
        return getPlateNum().equals(that.getPlateNum());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlateNum());
    }
}
