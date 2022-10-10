package org.example.service;

import org.example.converter.DtoToModelConverter;
import org.example.converter.ModelToDtoConverter;
import org.example.dto.CarDto;
import org.example.dto.DriverDto;
import org.example.dto.MotorcycleDto;
import org.example.dto.VehicleDto;
import org.example.exception.*;
import org.example.model.*;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.Random;

/** 
* GarageServiceImpl Tester. 
*
*/
class GarageServiceImplTest {

    GarageServiceImpl service;

@BeforeEach
public void setUp() {
    service = new GarageServiceImpl();
}

@AfterEach
public void cleanUp() {
    service.dao.getGarage().clear();
}


/** 
* 
* Tests vehicle entering the garage service.
* 
*/ 
@Test
void testEntersGarage() throws InvalidNameException, InvalidPlateNumberException, PlateNumAlreadyExistsException, GarageFullException {
    VehicleDto car = new CarDto(ModelToDtoConverter.toDto(getRandomDriver()), ModelToDtoConverter.toDto(getRandomStaff()), "AAA-0000");
    VehicleDto moto = new MotorcycleDto(ModelToDtoConverter.toDto(getRandomDriver()), ModelToDtoConverter.toDto(getRandomStaff()), "AAA-1234");

    service.entersGarage(car);
    service.entersGarage(moto);

    VehicleDto carFromDao = ModelToDtoConverter.toDto(service.dao.findVehicleByPlateNumber(car.getPlateNum()));
    VehicleDto motoFromDao = ModelToDtoConverter.toDto(service.dao.findVehicleByPlateNumber(moto.getPlateNum()));

    Assertions.assertEquals(car, carFromDao);
    Assertions.assertEquals(moto, motoFromDao);

    Assertions.assertThrows(PlateNumAlreadyExistsException.class, () -> service.entersGarage(car));

    moto.setDriver(new DriverDto("", ""));
    moto.setPlateNum("AAA-1111");
    Assertions.assertThrows(InvalidNameException.class, () -> service.entersGarage(moto));

    moto.setDriver(new DriverDto(getRandomString(), "12345"));
    Assertions.assertThrows(InvalidNameException.class, () -> service.entersGarage(moto));

    moto.setDriver(ModelToDtoConverter.toDto(getRandomDriver()));
    moto.setPlateNum(getRandomString());
    Assertions.assertThrows(InvalidPlateNumberException.class, () -> service.entersGarage(moto));

    for (int i = 0; i < 198; i++) {
        String str = Integer.toString(i);
        service.dao.getGarage().put(str, getRandomCar());
    }
    moto.setPlateNum("AAA-2222");
    Assertions.assertThrows(GarageFullException.class, () -> service.entersGarage(moto));

} 

/** 
* 
* Test vehicle exiting the garage service.
* 
*/ 
@Test
void testExitsGarage() throws InvalidNameException, InvalidPlateNumberException, PlateNumAlreadyExistsException, GarageFullException, PlateNumNotFoundException {
    VehicleDto car = new CarDto(ModelToDtoConverter.toDto(getRandomDriver()), ModelToDtoConverter.toDto(getRandomStaff()), "AAA-0000");
    VehicleDto car2 = new CarDto(car.getDriver(), car.getStaff(), "AAA-1111");
    service.entersGarage(car);

    Assertions.assertThrows(InvalidPlateNumberException.class, () -> service.exitsGarage(getRandomString()));
    Assertions.assertThrows(PlateNumNotFoundException.class, () -> service.exitsGarage("BBB-0000"));

    service.dao.findVehicleByPlateNumber(car.getPlateNum()).setEntranceDateTime(LocalDateTime.now().minusHours(3));
    Assertions.assertEquals(3.0 * car.getCharge(), service.exitsGarage(car.getPlateNum()));

    service.entersGarage(car);
    service.dao.findVehicleByPlateNumber(car.getPlateNum()).setEntranceDateTime(LocalDateTime.now().minusMinutes(30));
    Assertions.assertEquals(0.0, service.exitsGarage(car.getPlateNum()));

    service.entersGarage(car);
    service.entersGarage(car2);
    service.dao.findVehicleByPlateNumber(car.getPlateNum()).setEntranceDateTime(LocalDateTime.now().minusHours(3));
    Assertions.assertEquals(0.7 * 3.0 * car.getCharge(), service.exitsGarage(car.getPlateNum()));
}

/** 
* 
* Method: getEmptySpotsNumber()
* 
*/ 
@Test
void testGetEmptySpotsNumber() throws GarageFullException {
    int daoSpots = service.dao.getVacantSpotsNumber();
    int serviceSpots = service.getEmptySpotsNumber();

    Assertions.assertEquals(daoSpots, serviceSpots);

    for (int i = 0; i < 200; i++) {
        String str = Integer.toString(i);
        service.dao.getGarage().put(str, getRandomCar());
    }

    Assertions.assertThrows(GarageFullException.class, () -> service.getEmptySpotsNumber());
} 

/** 
* 
* Method: getTotalMoneyEarned() 
* 
*/ 
@Test
void testGetTotalMoneyEarned() {
    double daoMoney = service.dao.getTotalMoneyEarned();
    double serviceMoney = service.getTotalMoneyEarned();

    Assertions.assertEquals(daoMoney, serviceMoney);
}

/** 
* 
* Method: getStaffDetails(String plateNum) 
* 
*/ 
@Test
void testGetStaffDetails() throws InvalidNameException, InvalidPlateNumberException, PlateNumAlreadyExistsException, GarageFullException, PlateNumNotFoundException {
    VehicleDto car = new CarDto(ModelToDtoConverter.toDto(getRandomDriver()), ModelToDtoConverter.toDto(getRandomStaff()), "AAA-0000");
    service.entersGarage(car);

    Assertions.assertEquals(car.getStaff(), service.getStaffDetails(car.getPlateNum()));
}

private String getRandomString() {
    int leftLimit = 97;
    int rightLimit = 122;
    int targetStringLength = 10;

    Random random = new Random();
    StringBuilder buffer = new StringBuilder(targetStringLength);
    for (int i = 0; i < targetStringLength; i++) {
        int randomLimitedInt = leftLimit + (int)
                (random.nextFloat() * (rightLimit - leftLimit + 1));
        buffer.append((char) randomLimitedInt);
    }

    return buffer.toString();
}

private Driver getRandomDriver() {
    return new Driver(getRandomString(), getRandomString());
}

private Staff getRandomStaff() {
    return new Staff(getRandomString(), getRandomString());
}

private Car getRandomCar() {
    return new Car(getRandomDriver(), getRandomStaff(), getRandomString(), 2.0, LocalDateTime.now());
}

private Motorcycle getRandomMotorcycle() {
    return new Motorcycle(getRandomDriver(), getRandomStaff(), getRandomString(), 1.0, LocalDateTime.now());
}

} 
