package com.allstate.services;

import com.allstate.entities.Driver;
import com.allstate.enums.Gender;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class DriverServiceTest {
    @Autowired
    private DriverService driverService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateDriver() throws Exception {
        Driver driver = new Driver("Drivername", 55, Gender.M);
        Driver result = this.driverService.create(driver);
        assertEquals(4, result.getId());
    }

    @Test
    public void shouldFindDriverById() throws Exception {
        Driver driver = this.driverService.findById(1);
        assertEquals("Geeta", driver.getName());
    }

    @Test
    public void shouldDeleteDriverById() throws Exception {
        this.driverService.delete(3);
        Driver driver = this.driverService.findById(3);
        assertNull(driver);
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void shouldNotDeleteDriverByIdIfTripExist() throws Exception {
        this.driverService.delete(1);
        Driver driver = this.driverService.findById(1);
        assertNull(driver);
    }

    @Test
    public void shouldAddViolationForDriver() throws Exception {
        Driver driver = this.driverService.findById(1);
        driver.setViolations(driver.getViolations() + 1);
        Driver result = this.driverService.updateViolations(driver);
        assertEquals(1, result.getViolations());
        assertEquals(1, result.getId());
    }
}