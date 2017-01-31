package com.allstate.services;

import ch.qos.logback.core.html.IThrowableRenderer;
import com.allstate.entities.Trip;
import com.allstate.repositories.ITripRepository;
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

    public Trip create(Trip trip) {
        return  this.tripRepository.save(trip);
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
}
