package com.mamutawah.dojo.repositories;

import java.util.List;

import com.mamutawah.dojo.models.Ninja;

import org.springframework.data.repository.CrudRepository;

public interface NinjaRepository extends CrudRepository<Ninja, Long> {

  List<Ninja> findAll();
}