package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.repositories.ICityRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class CityServiceTest {
    @Autowired
    private CityService cityService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreateCity() throws Exception {
        City newCity = new City("Panjim","Goa");
        City city = this.cityService.create(newCity);
        assertEquals(5, city.getId());
    }

    @Test
    public void shouldFindCityById() throws Exception {
        City city = this.cityService.findById(1);
        assertEquals(1, city.getId());
        assertEquals("Bangalore", city.getName());
    }

    @Test
    public void shouldFindAllCities() throws Exception {
        List<City> cities = this.cityService.findAll();
        assertEquals(4,cities.size());
    }

    @Test
    public void shouldDeleteCityById() throws Exception {
        this.cityService.delete(1);
        City city = this.cityService.findById(1);
        assertNull(city);
    }
}