package com.mamutawah.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.mamutawah.events.models.CreateUser;
import com.mamutawah.events.models.LoginUser;
import com.mamutawah.events.models.User;
import com.mamutawah.events.services.LoginService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

  private final LoginService loginService;

  public HomeController(LoginService loginService) {
    this.loginService = loginService;
  }

  @RequestMapping("")
  public String index(@ModelAttribute("createUser") CreateUser createUser,
      @ModelAttribute("loginUser") LoginUser loginUser, Model model, HttpSession session) {
    if (session.getAttribute("userId") != null) {
      return "redirect:/events";
    }

    model.addAttribute("states", loginService.getAll());
    return "index.jsp";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String login(@ModelAttribute("createUser") CreateUser createUser,
      @Valid @ModelAttribute("loginUser") LoginUser loginUser, BindingResult result, Model model, HttpSession session) {

    if (loginService.authenticateUser(loginUser.getEmail(), loginUser.getPassword())) {
      User user = loginService.findByEmail(loginUser.getEmail());
      session.setAttribute("userId", user.getId());
      return "redirect:/events";
    }

    return "index.jsp";
  }

  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String register(@Valid @ModelAttribute("createUser") CreateUser createUser, BindingResult result,
      @ModelAttribute("loginUser") LoginUser loginUser, Model model) {
    loginService.registerUser(createUser, result);
    if (result.hasErrors()) {
      model.addAttribute("states", loginService.getAll());
      return "index.jsp";
    }

    return "redirect:/";
  }

  @RequestMapping(value = "/logout")
  public String logout(HttpSession session) {
    session.invalidate();
    return "redirect:/";
  }

}
