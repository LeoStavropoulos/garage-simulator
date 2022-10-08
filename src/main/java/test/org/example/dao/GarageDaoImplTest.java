package test.org.example.dao; 

import org.example.dao.GarageDaoImpl;
import org.example.model.*;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;


public class GarageDaoImplTest {

    GarageDaoImpl dao;

@BeforeEach
public void setUp() {
    dao = GarageDaoImpl.getInstance();
}

/** 
* 
* Tests inserting new vehicle into the garage.
* 
*/ 
@Test
public void testInsertVehicle()  {
    Driver driver1 = new Driver("Driver", "One", 1L);
    Driver driver2 = new Driver("Driver", "Two", 2L);
    Staff staff1 = new Staff("Staff", "One", 3L);
    Staff staff2 = new Staff("Staff", "Two", 4L);

    LocalDateTime now = LocalDateTime.now();

    Vehicle car = new Car(10L, driver1,staff1,"AAA-0000", 2.0, now);
    Vehicle moto = new Motorcycle(20L, driver2, staff2, "ZZZ-9999", 1.0, now);

    dao.insertVehicle(car);
    dao.insertVehicle(moto);

    Assertions.assertFalse(dao.getGarage().isEmpty());
    Assertions.assertEquals(2, dao.getGarage().size());

    Assertions.assertTrue(dao.getGarage().containsKey("AAA-0000"));
    Assertions.assertTrue(dao.getGarage().containsKey("ZZZ-9999"));

    Assertions.assertEquals(car, dao.getGarage().get("AAA-0000"));
    Assertions.assertEquals(driver1, dao.getGarage().get("AAA-0000").getDriver());
    Assertions.assertEquals(staff1, dao.getGarage().get("AAA-0000").getStaff());

    Assertions.assertEquals(moto, dao.getGarage().get("ZZZ-9999"));
    Assertions.assertEquals(driver2, dao.getGarage().get("ZZZ-9999").getDriver());
    Assertions.assertEquals(staff2, dao.getGarage().get("ZZZ-9999").getStaff());
}

/** 
* 
* Tests removing vehicles from the garage.
* 
*/ 
@Test
public void testRemoveVehicle() {
    Driver driver1 = new Driver("Driver", "One", 1L);
    Driver driver2 = new Driver("Driver", "Two", 2L);
    Staff staff1 = new Staff("Staff", "One", 3L);
    Staff staff2 = new Staff("Staff", "Two", 4L);

    LocalDateTime now = LocalDateTime.now();

    Vehicle car = new Car(10L, driver1,staff1,"AAA-0000", 2.0, now);
    Vehicle moto = new Motorcycle(20L, driver2, staff2, "ZZZ-9999", 1.0, now);

    dao.insertVehicle(car);
    dao.insertVehicle(moto);

    Assertions.assertFalse(dao.getGarage().isEmpty());
    Assertions.assertEquals(2, dao.getGarage().size());

    dao.removeVehicle("AAA-0000");
    Assertions.assertEquals(1, dao.getGarage().size());
    Assertions.assertFalse(dao.getGarage().containsKey("AAA-0000"));
    Assertions.assertTrue(dao.getGarage().containsKey("ZZZ-9999"));

    dao.removeVehicle("ZZZ-9999");
    Assertions.assertEquals(0, dao.getGarage().size());
    Assertions.assertFalse(dao.getGarage().containsKey("ZZZ-9999"));
}

/** 
* 
* Tests if a vehicle can be found by its plate number.
* 
*/ 
@Test
public void testFindVehicleByPlateNumber() {
    Driver driver1 = new Driver("Driver", "One", 1L);
    Driver driver2 = new Driver("Driver", "Two", 2L);
    Staff staff1 = new Staff("Staff", "One", 3L);
    Staff staff2 = new Staff("Staff", "Two", 4L);

    LocalDateTime now = LocalDateTime.now();

    Vehicle car = new Car(10L, driver1,staff1,"AAA-0000", 2.0, now);
    Vehicle moto = new Motorcycle(20L, driver2, staff2, "ZZZ-9999", 1.0, now);

    dao.insertVehicle(car);
    dao.insertVehicle(moto);

    Assertions.assertEquals(car, dao.findVehicleByPlateNumber(car.getPlateNum()));
    Assertions.assertEquals(moto, dao.findVehicleByPlateNumber(moto.getPlateNum()));
}

/** 
* 
* Tests if an amount of money can be added to the total money earned and the if it can be retrieved.
* 
*/ 
@Test
public void testAddMoneyAndGetTotalMoneyEarned() {
    Double amount = 100.0;

    dao.addMoney(amount);

    Assertions.assertEquals(amount, dao.getTotalMoneyEarned());
}

/** 
* 
* Tests if the number of available parking spots can be retrieved.
* 
*/ 
@Test
public void testGetVacantSpotsNumber() {
    Assertions.assertEquals(200, dao.getVacantSpotsNumber()); // Hard-coded garage size

    Driver driver1 = new Driver("Driver", "One", 1L);
    Staff staff1 = new Staff("Staff", "One", 3L);
    Vehicle car = new Car(10L, driver1,staff1,"AAA-0000", 2.0, LocalDateTime.now());

    dao.insertVehicle(car);

    Assertions.assertEquals(199, dao.getVacantSpotsNumber());
}

} 
