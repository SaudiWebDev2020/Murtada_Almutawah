package com.mamutawah.events.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mamutawah.events.models.State;

import java.util.List;

import com.mamutawah.events.models.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {

  List<Location> findByState(State state);

}
