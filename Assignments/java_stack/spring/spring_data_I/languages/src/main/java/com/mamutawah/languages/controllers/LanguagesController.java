package com.mamutawah.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import com.mamutawah.languages.models.Language;
import com.mamutawah.languages.services.LanguageService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LanguagesController {
  private final LanguageService languageService;

  public LanguagesController(LanguageService languageService) {
    this.languageService = languageService;
  }

  @RequestMapping("/languages")
  public String index(@ModelAttribute("language") Language language, Model model) {
    List<Language> languages = languageService.allLanguages();
    model.addAttribute("languages", languages);
    return "/languages/index.jsp";
  }

  @RequestMapping(value = "/languages", method = RequestMethod.POST)
  public String create(@Valid @ModelAttribute("language") Language newLanguage, BindingResult result, Model model) {

    if (result.hasErrors()) {
      List<Language> languages = languageService.allLanguages();
      model.addAttribute("languages", languages);
      return "/languages/index.jsp";
    } else {
      languageService.createLanguage(newLanguage);
      return "redirect:/languages";
    }
  }

  @RequestMapping("/languages/{id}")
  public String view(@PathVariable("id") Long id, Model model) {
    Language language = languageService.getOne(id);
    if (language != null) {
      model.addAttribute("language", language);
      return "/languages/show.jsp";
    }
    return "redirect:/languages";
  }

  @RequestMapping(value = "/languages/{id}", method = RequestMethod.DELETE)
  public String delete(@PathVariable("id") Long id) {
    languageService.remove(id);
    return "redirect:/languages";
  }

  @RequestMapping("/languages/{id}/edit")
  public String edit(@PathVariable("id") Long id, @ModelAttribute("language") Language language, Model model) {
    Language languageDetails = languageService.getOne(id);
    if (languageDetails != null) {
      model.addAttribute("language", languageDetails);
      return "/languages/edit.jsp";
    }

    return "redirect:/languages";
  }

  @RequestMapping(value = "/languages/{id}", method = RequestMethod.PUT)
  public String update(@Valid @ModelAttribute("language") Language language, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "/languages/edit.jsp";
    }

    languageService.update(language);
    return "redirect:/languages/" + language.getId();
  }

}