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
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class ReportServiceTest {
    @Autowired
    private TripService tripService;

    @Autowired
    private CityService cityService;

    @Autowired
    private DriverService driverService;

    @Autowired
    private ReportService reportService;

    @Autowired
    private CarService carService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldFindAllTrips() throws Exception {
        List<Trip> trips = this.tripService.findAll();
        assertEquals(2, trips.size());
    }

    @Test
    @Transactional
    public void shouldFindTripsByCityId() throws Exception {
        City city = this.cityService.findById(1);
        List<Trip> trips = city.getTrips();
        assertEquals(2, trips.size());
    }

    @Test
    @Transactional
    public void shouldFindDriverByTripId() throws Exception {
        Trip trip = this.tripService.findById(1);
        Driver driver = trip.getDriver();
        assertEquals(1, driver.getId());
    }

    @Test
    @Transactional
    public void shouldFindDriversByCityId() throws Exception {
        City city = this.cityService.findById(1);
        List<Driver> drivers = city.getDrivers();
        assertEquals(2, city.getDrivers().size());
    }

    @Test
    @Transactional
    public void shouldFindAllCitiesByDriverId_WithNoDistinct() throws Exception {
        Driver driver = this.driverService.findById(1);
        List<City> cities = driver.getCities();
        assertEquals(3, cities.size());
    }

    @Test
    @Transactional
    public void shouldFindAllCitiesByDriverId_DistinctValues() throws Exception {
        List<City> cities = this.reportService.findDistinctCitiesByDriverId(1);
        assertEquals(2, cities.size());
    }

    @Test
    public void shouldFindAllTripsForACar() throws Exception {
        List<Trip> trips = this.tripService.findByCarIdIs(1);
        assertEquals(2, trips.size());
    }

    @Test
    public void shouldFindAllTripsByDriverId() throws Exception {
        List<Trip> trips = this.tripService.findByDriverIdIs(1);
        assertEquals(3, trips.size());
    }

    @Test
    public void shouldFindCarAndDriverAndPassengerByTripId() throws Exception {
        Trip trip = this.tripService.findById(1);
        Car car = trip.getCar();
        Driver driver = trip.getDriver();
        Passenger passenger = trip.getPassenger();
        assertEquals(1, car.getId());
        assertEquals(1, driver.getId());
        assertEquals(1, passenger.getId());
    }

    @Test
    public void shouldFindAllPassengersByCityId() throws Exception {
        List<Passenger> passenger = this.reportService.findDistinctPassengersByCityId(2);
        assertEquals(2, passenger.size());
    }
}