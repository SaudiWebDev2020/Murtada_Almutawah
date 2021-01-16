package com.mamutawah.relationships.controllers;

import javax.validation.Valid;

import com.mamutawah.relationships.models.License;
import com.mamutawah.relationships.models.Person;
import com.mamutawah.relationships.services.PersonService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PersonsController {
  private final PersonService personService;

  public PersonsController(PersonService personService) {
    this.personService = personService;
  }

  @RequestMapping("/")
  public String viewAll(Model model) {
    model.addAttribute("persons", personService.getAll());
    System.out.println(personService.getAll());
    return "/index.jsp";
  }

  @RequestMapping("/persons/new")
  public String newPerson(@ModelAttribute("person") Person person, Model model) {
    return "/persons/new.jsp";
  }

  @RequestMapping("/licenses/new")
  public String newLicense(@ModelAttribute("license") License license, Model model) {
    model.addAttribute("persons", this.personService.getAllWithoutLicense());
    return "/licenses/new.jsp";
  }

  @RequestMapping("/{id}")
  public String viewPerson(@PathVariable("id") Long id, Model model) {
    model.addAttribute("person", this.personService.getOne(id));
    return "/persons/view.jsp";
  }

  @RequestMapping(value = "/licenses/new", method = RequestMethod.POST)
  public String create(@Valid @ModelAttribute("license") License license, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("persons", this.personService.getAllWithoutLicense());
      return "/licenses/new.jsp";
    }
    personService.createLicense(license);
    // System.out.println(String.format("%06d", license.getPerson().getId()));
    // System.out.println(Pe.getId());
    // return "/licenses/new.jsp";
    return "redirect:/";
  }

  @RequestMapping(value = "/persons/new", method = RequestMethod.POST)
  public String create(@Valid @ModelAttribute("person") Person person, BindingResult result, Model model) {
    if (result.hasErrors()) {
      return "/person/new.jsp";
    } else {
      personService.create(person);
      return "redirect:/";
    }
  }

}