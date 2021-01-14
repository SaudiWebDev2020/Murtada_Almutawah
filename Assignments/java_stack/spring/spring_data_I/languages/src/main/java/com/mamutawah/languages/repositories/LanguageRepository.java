package com.mamutawah.languages.repositories;

import java.util.List;

import com.mamutawah.languages.models.Language;

import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language, Long> {

  List<Language> findAll();
}