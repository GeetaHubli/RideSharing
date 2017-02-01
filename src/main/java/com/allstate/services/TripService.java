package com.allstate.services;

import ch.qos.logback.core.html.IThrowableRenderer;
import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import com.allstate.repositories.IDriverRepository;
import com.allstate.repositories.ITripRepository;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService {
    private ITripRepository tripRepository;

    @Autowired
    public void setTripRepository(ITripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    public Trip create(Trip trip, Driver driver, Passenger passenger) {
        if(driver.getViolations()<=3 && passenger.getBalance() > 0)
            return this.tripRepository.save(trip);
        else
            return null;
    }

    public Trip findById(int id) {
        return this.tripRepository.findOne(id);
    }

    public void delete(int id) {
        this.tripRepository.delete(id);
    }

    public List<Trip> findByCarIdIs(int carId) {
        return (List<Trip>) this.tripRepository.findByCarIdIs(carId);
    }

    public List<Trip> findAll() {
        return (List<Trip>) this.tripRepository.findAll();
    }
}
