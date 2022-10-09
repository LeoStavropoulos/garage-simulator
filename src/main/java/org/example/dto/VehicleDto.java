package org.example.dto;

import java.time.LocalDateTime;

public abstract class VehicleDto extends AbstractDto{
    private DriverDto driver;

    private StaffDto staff;

    private String plateNum;

    private Double charge;

    private LocalDateTime entranceDateTime;

    protected VehicleDto(Long id, DriverDto driver, StaffDto staff, String plateNum, Double charge, LocalDateTime entranceDateTime) {
        this.setId(id);
        this.driver = driver;
        this.staff = staff;
        this.plateNum = plateNum;
        this.charge = charge;
        this.entranceDateTime = entranceDateTime;
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
}
