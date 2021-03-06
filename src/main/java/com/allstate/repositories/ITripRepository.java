package com.allstate.repositories;

import com.allstate.entities.City;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITripRepository extends CrudRepository<Trip, Integer> {
    public Iterable<Trip> findByCarIdIs(int carId);

    public Iterable<Trip> findByDriverIdIs(int id);

    public Iterable<Trip> findByCityIdIs(int id);
}
