package com.allstate.services;

import com.allstate.entities.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import java.sql.Timestamp;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TripServiceTest {
    @Autowired
    private TripService tripService;

    @Autowired
    private CarService carService;

    @Autowired
    private PassengerService passengerService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private CityService cityService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void shouldCreateTrip() throws Exception {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Car car = this.carService.findById(1);
        Passenger passenger = this.passengerService.findById(1);
        City city = this.cityService.findById(1);
        Driver driver = this.driverService.findById(1);
        Trip trip = new Trip(30.00, timestamp, timestamp, car, passenger, driver, city, 10, 200.00, 200.00);
        Trip result = this.tripService.create(trip, driver, passenger);
        assertEquals(3, result.getId());
    }

    @Test
    public void shouldNotCreateTripForDriverBanned() throws Exception {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Car car = this.carService.findById(1);
        Passenger passenger = this.passengerService.findById(1);
        City city = this.cityService.findById(1);
        Driver driver = this.driverService.findById(3);
        Trip trip = new Trip(30.00, timestamp, timestamp, car, passenger, driver, city, 10, 200.00, 200.00);
        Trip result = this.tripService.create(trip, driver, passenger);
        assertNull(result);
    }

    @Test
    public void shouldNotCreateTripForPassengerBalanceNotEnough() throws Exception {
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        Car car = this.carService.findById(1);
        Passenger passenger = this.passengerService.findById(3);
        City city = this.cityService.findById(1);
        Driver driver = this.driverService.findById(1);
        Trip trip = new Trip(30.00, timestamp, timestamp, car, passenger, driver, city, 10, 200.00, 200.00);
        Trip result = this.tripService.create(trip, driver, passenger);
        assertNull(result);
    }

    @Test
    public void shouldFindTripById() throws Exception {
        Trip trip = this.tripService.findById(1);
        assertEquals(1, trip.getId());
        assertEquals(30.00, trip.getDuration(), 0.1);
    }

    @Test
    public void shouldDeleteTripById() throws Exception {
        this.tripService.delete(2);
        assertNull(this.tripService.findById(2));

    }
}