package com.mamutawah.relationships.repositories;

import java.util.List;

import com.mamutawah.relationships.models.License;

import org.springframework.data.repository.CrudRepository;

public interface LicenseRepository extends CrudRepository<License, Long> {
  public List<License> findAll();

  public License findTopByOrderByNumberDesc();
}
