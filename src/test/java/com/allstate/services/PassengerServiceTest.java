package com.allstate.services;

import com.allstate.entities.Passenger;
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
public class PassengerServiceTest {
    @Autowired
    private PassengerService passengerService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldCreatePassenger() throws Exception {
        Passenger passenger = new Passenger("test", 25, Gender.M, 1000.00);
        Passenger result = this.passengerService.create(passenger);
        assertEquals(4, result.getId());
    }

    @Test
    public void shouldFindPassengerById() throws Exception {
        Passenger result = this.passengerService.findById(1);
        assertEquals(1, result.getId());
        assertEquals("Swapnil", result.getName());
    }

    @Test
    public void shouldDeletePassengerById() throws Exception {
        this.passengerService.delete(3);
        Passenger result = this.passengerService.findById(3);
        assertNull(result);

    }
}