package com.allstate.services;

import com.allstate.entities.Car;
import com.allstate.entities.Driver;
import com.allstate.entities.Trip;
import com.allstate.enums.Cartype;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.Table;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @Autowired
    private TripService tripService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCar() throws Exception {
        Car car = new Car("HYUNDAI", "Santro", 2010, Cartype.BASIC);
        Car result = this.carService.create(car);
        assertEquals(5, result.getId());
    }

    @Test
    public void shouldFindCarById() throws Exception {
        Car car = this.carService.findById(1);
        assertEquals(1, car.getId());
        assertEquals("BMW", car.getMake());
    }

    @Test
    public void shouldFindTripWithCarId() throws Exception {
        List<Trip> trip = this.tripService.findByCarIdIs(1);
        assertEquals(2, trip.size());
    }

    @Test
    public void shouldDeleteCarById() throws Exception {
        this.carService.delete(4);
        Car car = this.carService.findById(4);
        assertNull(car);
    }

    @Test(expected = org.springframework.dao.DataIntegrityViolationException.class)
    public void shouldNotDeleteCarByIdIfTripExist() throws Exception {
        this.carService.delete(1);
        Car car = this.carService.findById(1);
        assertNull(car);
    }

}