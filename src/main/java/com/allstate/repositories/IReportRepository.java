package com.allstate.repositories;

import com.allstate.entities.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IReportRepository extends CrudRepository<City, Long> {
    @Query("select distinct c from City c inner join c.trips t inner join t.driver d where d.id = :id")
    public List<City> findDistinctCitiesByDriverId(@Param("id") int id);
}
