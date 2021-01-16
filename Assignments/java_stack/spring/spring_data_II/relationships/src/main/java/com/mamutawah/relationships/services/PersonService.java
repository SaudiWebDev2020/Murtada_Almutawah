package com.mamutawah.relationships.services;

import java.util.List;

import com.mamutawah.relationships.models.License;
import com.mamutawah.relationships.models.Person;
import com.mamutawah.relationships.repositories.LicenseRepository;
import com.mamutawah.relationships.repositories.PersonRepository;

import org.springframework.stereotype.Service;

@Service
public class PersonService {
  private final PersonRepository personRepository;
  private final LicenseRepository licenseRepository;

  public PersonService(PersonRepository personRepository, LicenseRepository licenseRepository) {
    this.personRepository = personRepository;
    this.licenseRepository = licenseRepository;
  }

  public Person create(Person person) {
    return personRepository.save(person);
  }

  public List<Person> getAll() {
    return personRepository.findAll();
  }

  public Person getOne(Long id) {
    return personRepository.findById(id).orElse(null);
  }

  public List<Person> getAllWithoutLicense() {
    return personRepository.findByNoLicense();
  }

  public License createLicense(License license) {
    license.setNumber(this.generateLicenseNumber());
    return licenseRepository.save(license);
  }

  private String generateLicenseNumber() {
    License l = licenseRepository.findTopByOrderByNumberDesc();
    if (l == null)
      return String.format("%06d", 1);
    Long largestNumber = l.getId();
    largestNumber++;
    return String.format("%06d", largestNumber);
  }
}
