package com.mamutawah.dojosurvey.controllers;

import com.mamutawah.dojosurvey.models.Survey;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  @RequestMapping("/")
  public String index() {
    return "index.jsp";
  }

  @RequestMapping(value = "/result", method = RequestMethod.POST)
  public String result(@RequestParam(value = "name") String name,
      @RequestParam(value = "dojoLocation") String dojoLocation,
      @RequestParam(value = "favoriteLanguage") String favoriteLanguage,
      @RequestParam(value = "comment") String comment, Model model) {
    model.addAttribute("result", new Survey(name, dojoLocation, favoriteLanguage, comment));
    return "result.jsp";
  }
}
