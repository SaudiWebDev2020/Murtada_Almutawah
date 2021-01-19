package com.mamutawah.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.mamutawah.authentication.models.User;
import com.mamutawah.authentication.services.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// imports removed for brevity
@Controller
public class HomeController {

  private final UserService userService;

  public HomeController(UserService userService) {
    this.userService = userService;
  }

  @RequestMapping("/registration")
  public String registerForm(@ModelAttribute("user") User user, HttpSession session) {
    Long user_id = (Long) session.getAttribute("user_id");
    if (user_id != null) {
      return "redirect:/home";
    }

    return "registrationPage.jsp";
  }

  @RequestMapping("/login")
  public String login(HttpSession session) {
    Long user_id = (Long) session.getAttribute("user_id");
    if (user_id != null) {
      return "redirect:/home";
    }

    return "loginPage.jsp";
  }

  @RequestMapping(value = "/registration", method = RequestMethod.POST)
  public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
    // if result has errors, return the registration page (don't worry about
    // validations just now)
    if (result.hasErrors()) {
      return "registrationPage.jsp";
    }
    // else, save the user in the database, save the user id in session, and
    // redirect them to the /home route
    User newUser = userService.registerUser(user);
    session.setAttribute("user_id", newUser.getId());
    return "redirect:/home";
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model,
      HttpSession session) {
    if (userService.authenticateUser(email, password)) {
      User user = userService.findByEmail(email);
      System.out.println(user.getId());
      session.setAttribute("user_id", user.getId());
      return "redirect:/home";
    }

    // if the user is authenticated, save their user id in session
    // else, add error messages and return the login page
    model.addAttribute("error", "Email and password does not match!");
    return "loginPage.jsp";
  }

  @RequestMapping("/home")
  public String home(HttpSession session, Model model) {
    Long user_id = (Long) session.getAttribute("user_id");
    if (user_id == null) {
      return "redirect:/login";
    }
    // get user from session, save them in the model and return the home page
    User user = userService.findUserById(user_id);
    model.addAttribute("user", user);
    return "homePage.jsp";

  }

  @RequestMapping("/logout")
  public String logout(HttpSession session) {
    // invalidate session
    // redirect to login page
    // session.removeAttribute("user_id");
    session.invalidate();
    return "redirect:/login";
  }
}