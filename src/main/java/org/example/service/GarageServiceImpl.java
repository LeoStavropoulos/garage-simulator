package org.example.service;

import org.example.converter.DtoToModelConverter;
import org.example.converter.ModelToDtoConverter;
import org.example.dao.GarageDaoImpl;
import org.example.dto.*;
import org.example.exception.*;
import org.example.model.Driver;
import org.example.model.Vehicle;

import java.time.Duration;
import java.time.LocalDateTime;

public class GarageServiceImpl implements IGarageService{
    private static final GarageDaoImpl dao = GarageDaoImpl.getInstance();
    private static final Double CAR_CHARGE = 2.0;
    private static final Double MOTO_CHARGE = 1.0;

    @Override
    public void entersGarage(VehicleDto vehicleDto) throws InvalidNameException, GarageFullException, InvalidPlateNumberException, PlateNumAlreadyExistsException {

        vehicleDtoValidator(vehicleDto);

        if (dao.findVehicleByPlateNumber(vehicleDto.getPlateNum()) != null) throw new PlateNumAlreadyExistsException(vehicleDto.getPlateNum());

        if (vehicleDto.getClass().isInstance(CarDto.class)) {
            vehicleDto.setCharge(CAR_CHARGE);
        } else if (vehicleDto.getClass().isInstance(MotorcycleDto.class)) {
            vehicleDto.setCharge(MOTO_CHARGE);
        }

        vehicleDto.setEntranceDateTime(LocalDateTime.now());

        dao.insertVehicle(DtoToModelConverter.toModel(vehicleDto));
        dao.addDriver(DtoToModelConverter.toModel(vehicleDto.getDriver()));
    }

    @Override
    public Double exitsGarage(String plateNum) throws InvalidPlateNumberException, PlateNumNotFoundException {

        Driver driver;
        double price;
        Vehicle vehicle;
        long time;

        plateNumValidator(plateNum);
        if (dao.findVehicleByPlateNumber(plateNum) == null) throw new PlateNumNotFoundException(plateNum);

        vehicle = dao.findVehicleByPlateNumber(plateNum);

        driver = vehicle.getDriver();
        time = Duration.between(vehicle.getEntranceDateTime(), LocalDateTime.now()).toMinutes();

        if (time < 31L) {
            price = 0.0;
        } else {
            price = time * vehicle.getCharge();
        }

        dao.removeVehicle(plateNum);

        if (!dao.findIfDriverExists(driver)) {
            dao.removeDriver(dao.findVehicleByPlateNumber(plateNum).getDriver());
        } else {
            price *= 0.7;
        }

        dao.addMoney(price);
        return price;
    }

    @Override
    public int getEmptySpotsNumber() {
        return dao.getVacantSpotsNumber();
    }

    @Override
    public Double getTotalMoneyEarned() {
        return dao.getTotalMoneyEarned();
    }

    @Override
    public StaffDto getStaffDetails(String plateNum) throws InvalidPlateNumberException, PlateNumNotFoundException {
        Vehicle vehicle;

        plateNumValidator(plateNum);
        if (dao.findVehicleByPlateNumber(plateNum) == null) throw new PlateNumNotFoundException(plateNum);

        vehicle = dao.findVehicleByPlateNumber(plateNum);

        return ModelToDtoConverter.toDto(vehicle.getStaff());
    }

    private void nameValidator(String name, String field) throws InvalidNameException {
        if (!name.matches("[a-zA-Z]+")) {
            throw new InvalidNameException(field);
        }
    }

    private void plateNumValidator(String plateNum) throws InvalidPlateNumberException {
        if (!plateNum.matches("^([A-Z]{3})-(\\d{4})")) {
            throw new InvalidPlateNumberException();
        }
    }

    private void vehicleDtoValidator(VehicleDto vehicleDto) throws InvalidNameException, InvalidPlateNumberException, GarageFullException {
        String plateNum = vehicleDto.getPlateNum();
        DriverDto driver = vehicleDto.getDriver();
        StaffDto staff = vehicleDto.getStaff();

        if (getEmptySpotsNumber() == 0) throw new GarageFullException();

        nameValidator(driver.getFirstName(), "firstname");
        nameValidator(driver.getLastName(), "lastname");

        nameValidator(staff.getFirstName(), "firstname");
        nameValidator(staff.getLastName(), "lastname");

        plateNumValidator(plateNum);
    }
}
