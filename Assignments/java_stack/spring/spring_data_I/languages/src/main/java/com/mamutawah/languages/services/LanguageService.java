package com.mamutawah.languages.services;

import java.util.List;

import com.mamutawah.languages.models.Language;
import com.mamutawah.languages.repositories.LanguageRepository;

import org.springframework.stereotype.Service;

@Service
public class LanguageService {

  private final LanguageRepository languageRepository;

  public LanguageService(LanguageRepository languageRepository) {
    this.languageRepository = languageRepository;
  }

  // return all the languages
  public List<Language> allLanguages() {
    return languageRepository.findAll();
  }

  // create a language
  public Language createLanguage(Language newLanguage) {
    return languageRepository.save(newLanguage);
  }

  public Language getOne(Long id) {
    if (languageRepository.existsById(id)) {
      return languageRepository.findById(id).get();
    }

    return null;
  }

  public Language update(Language language) {
    return languageRepository.save(language);
  }

  public void remove(Long id) {
    if (languageRepository.existsById(id)) {
      languageRepository.deleteById(id);
    }
  }
}