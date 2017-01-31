package com.allstate.repositories;

import com.allstate.entities.Driver;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by localadmin on 31/01/17.
 */
public interface IDriverRepository extends CrudRepository<Driver, Integer> {
}
