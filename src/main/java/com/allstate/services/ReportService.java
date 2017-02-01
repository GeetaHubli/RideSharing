package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.entities.Driver;
import com.allstate.entities.Passenger;
import com.allstate.entities.Trip;
import com.allstate.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    private IReportRepository reportRepository;
    @Autowired
    public void setReportRepository(IReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    private ITripRepository tripRepository;
    @Autowired
    public void setTripRepository(ITripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    private ICarRepository carRepository;
    @Autowired
    public void setCarRepository(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }

    private ICityRepository cityRepository;
    @Autowired
    public void setCityRepository(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    private IDriverRepository driverRepository;
    @Autowired
    public void setDriverRepository(IDriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    private IPassengerRepository passengerRepository;
    @Autowired
    public void setPassengerRepository(IPassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<City> findDistinctCitiesByDriverId(int id) {
        return this.reportRepository.findDistinctCitiesByDriverId(id);
    }

    public List<Passenger> findDistinctPassengersByCityId(int id) {
        return this.reportRepository.findDistinctPassengersByCityId(id);
    }

    public List<Driver> findDistinctDriverByPassengerId(int id) {
        return this.reportRepository.findDistinctDriverByPassengerId(id);
    }
}
