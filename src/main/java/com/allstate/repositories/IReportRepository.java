package com.allstate.repositories;

import com.allstate.entities.City;
import com.allstate.entities.Passenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReportRepository extends CrudRepository<City, Long> {
    @Query("select distinct c from City c inner join c.trips t inner join t.driver d where d.id = :id")
    public List<City> findDistinctCitiesByDriverId(@Param("id") int id);


    @Query("select distinct p from Passenger p inner join p.trips t inner join t.city c where c.id = :id")
    public List<Passenger> findDistinctPassengersByCityId(@Param("id") int id);
}
