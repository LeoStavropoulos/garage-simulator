package org.example.dao;

import org.example.exception.GarageFullException;
import org.example.model.*;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;


class GarageDaoImplTest {

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
    void testInsertVehicle()  {
        Driver driver1 = new Driver("Driver", "One");
        Driver driver2 = new Driver("Driver", "Two");
        Staff staff1 = new Staff("Staff", "One");
        Staff staff2 = new Staff("Staff", "Two");

        LocalDateTime now = LocalDateTime.now();

        Vehicle car = new Car(driver1,staff1,"AAA-0000", 2.0, now);
        Vehicle moto = new Motorcycle(driver2, staff2, "ZZZ-9999", 1.0, now);

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
    void testRemoveVehicle() {
        Driver driver1 = new Driver("Driver", "One");
        Driver driver2 = new Driver("Driver", "Two");
        Staff staff1 = new Staff("Staff", "One");
        Staff staff2 = new Staff("Staff", "Two");

        LocalDateTime now = LocalDateTime.now();

        Vehicle car = new Car(driver1,staff1,"AAA-0000", 2.0, now);
        Vehicle moto = new Motorcycle(driver2, staff2, "ZZZ-9999", 1.0, now);

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
    void testFindVehicleByPlateNumber() {
        Driver driver1 = new Driver("Driver", "One");
        Driver driver2 = new Driver("Driver", "Two");
        Staff staff1 = new Staff("Staff", "One");
        Staff staff2 = new Staff("Staff", "Two");

        LocalDateTime now = LocalDateTime.now();

        Vehicle car = new Car(driver1,staff1,"AAA-0000", 2.0, now);
        Vehicle moto = new Motorcycle(driver2, staff2, "ZZZ-9999", 1.0, now);

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
    void testAddMoneyAndGetTotalMoneyEarned() {
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
    void testGetVacantSpotsNumber() throws GarageFullException {
        Assertions.assertEquals(200, dao.getVacantSpotsNumber()); // Hard-coded garage size

        Driver driver1 = new Driver("Driver", "One");
        Staff staff1 = new Staff("Staff", "One");
        Vehicle car = new Car(driver1,staff1,"AAA-0000", 2.0, LocalDateTime.now());

        dao.insertVehicle(car);

        Assertions.assertEquals(199, dao.getVacantSpotsNumber());
    }

    /**
     *
     * Tests adding a driver into the drivers set.
     *
     */
    @Test
    void testAddDriver()  {
        Driver driver = new Driver("Driver", "One");

        dao.addDriver(driver);

        Assertions.assertFalse(dao.getDrivers().isEmpty());
        Assertions.assertEquals(1, dao.getDrivers().size());
        Assertions.assertTrue(dao.getDrivers().stream()
                .anyMatch(item -> item.getFirstName().equals(driver.getFirstName()) &&
                        item.getLastName().equals(driver.getLastName())));
    }

    /**
     *
     * Tests removing a driver from the drivers set.
     *
     */
    @Test
    void testRemoveDriver()  {
        Driver driver = new Driver("Driver", "One");
        dao.getDrivers().add(driver);

        Assertions.assertFalse(dao.getDrivers().isEmpty());

        dao.removeDriver(driver);

        Assertions.assertTrue(dao.getDrivers().isEmpty());
        Assertions.assertTrue(dao.getDrivers().stream()
                .noneMatch(item -> item.getFirstName().equals(driver.getFirstName()) &&
                        item.getLastName().equals(driver.getLastName())));
    }

    @Test
    void findIfDriverExists() {
        Driver driver = new Driver("Driver", "One");
        dao.addDriver(driver);

        Assertions.assertTrue(dao.findIfDriverExists(driver));
    }
}
