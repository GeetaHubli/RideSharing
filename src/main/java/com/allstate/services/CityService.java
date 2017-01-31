package com.allstate.services;

import com.allstate.entities.City;
import com.allstate.repositories.ICityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private ICityRepository cityRepository;

    @Autowired
    public void setCityRepository(ICityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City create(City city) {
        return this.cityRepository.save(city);
    }

    public City findById(int id) {
        return this.cityRepository.findOne(id);
    }

    public List<City> findAll() {
        return (List<City>) this.cityRepository.findAll();
    }

    public void delete(int id) {
        this.cityRepository.delete(id);
    }
}
