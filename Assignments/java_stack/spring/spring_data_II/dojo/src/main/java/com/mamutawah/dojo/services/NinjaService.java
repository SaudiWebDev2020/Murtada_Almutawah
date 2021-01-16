package com.mamutawah.dojo.services;

import com.mamutawah.dojo.models.Ninja;
import com.mamutawah.dojo.repositories.NinjaRepository;

import org.springframework.stereotype.Service;

@Service
public class NinjaService {

  private final NinjaRepository ninjaRepository;

  public NinjaService(NinjaRepository ninjaRepository) {
    this.ninjaRepository = ninjaRepository;
  }

  public Ninja create(Ninja ninja) {
    return ninjaRepository.save(ninja);
  }

}
