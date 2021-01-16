package com.mamutawah.dojo.controllers;

import java.util.List;

import javax.validation.Valid;

import com.mamutawah.dojo.models.Dojo;
import com.mamutawah.dojo.models.Ninja;
import com.mamutawah.dojo.services.DojoService;
import com.mamutawah.dojo.services.NinjaService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

  private final DojoService dojoService;
  private final NinjaService ninjaService;

  public HomeController(DojoService dojoService, NinjaService ninjaService) {
    this.dojoService = dojoService;
    this.ninjaService = ninjaService;

  }

  @RequestMapping("/")
  public String index(Model model) {
    model.addAttribute("dojos", dojoService.getAll());
    return "index.jsp";
  }

  @RequestMapping("/dojos/new")
  public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
    return "dojos/new.jsp";
  }

  @RequestMapping(value = "/dojos/new", method = RequestMethod.POST)
  public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
    if (result.hasErrors()) {
      return "dojos/new.jsp";
    }
    dojoService.createDojo(dojo);
    return "redirect:/";
  }

  @RequestMapping("/ninjas/new")
  public String createNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
    model.addAttribute("dojos", dojoService.getAll());
    return "ninjas/new.jsp";
  }

  @RequestMapping(value = "/ninjas/new", method = RequestMethod.POST)
  public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("dojos", dojoService.getAll());
      return "ninjas/new.jsp";
    }
    ninjaService.create(ninja);
    // System.out.println(ninja);
    return "redirect:/";
  }

  @RequestMapping("/dojos/{id}")
  public String getAllNinjaOfDojo(@PathVariable("id") Long id, Model model) {
    model.addAttribute("dojo", dojoService.getOne(id));
    System.out.println(dojoService.getOne(id).getName());
    return "dojos/view.jsp";
  }
}
