package com.mamutawah.events.repositories;

import java.util.List;

import com.mamutawah.events.models.Event;
import com.mamutawah.events.models.Location;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface EventRepository extends CrudRepository<Event, Long> {

  List<Event> findByLocation(Location location);

  @Query(value = "SELECT * FROM events.events left join events.locations on locations.id = events.location_id where state_id = :stateOfUser", nativeQuery = true)
  List<Event> findAllFromState(@Param("stateOfUser") Long stateId);

  @Query(value = "SELECT * FROM events.events left join events.locations on locations.id = events.location_id where state_id != :stateOfUser", nativeQuery = true)
  List<Event> findAllFromOtherState(@Param("stateOfUser") Long stateId);
}