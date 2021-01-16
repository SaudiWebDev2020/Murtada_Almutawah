package com.mamutawah.dojo.services;

import java.util.List;

import com.mamutawah.dojo.models.Dojo;
import com.mamutawah.dojo.repositories.DojoRepository;

import org.springframework.stereotype.Service;

@Service
public class DojoService {

  private final DojoRepository dojoRepository;

  public DojoService(DojoRepository dojoRepository) {
    this.dojoRepository = dojoRepository;
  }

  public List<Dojo> getAll() {
    return dojoRepository.findAll();
  }

  public Dojo getOne(Long id) {
    return dojoRepository.findById(id).orElse(null);
  }

  public Dojo createDojo(Dojo dojo) {
    return dojoRepository.save(dojo);
  }
}
