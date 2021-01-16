package com.mamutawah.dojo.repositories;

import java.util.List;

import com.mamutawah.dojo.models.Dojo;

import org.springframework.data.repository.CrudRepository;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
  List<Dojo> findAll();
}
