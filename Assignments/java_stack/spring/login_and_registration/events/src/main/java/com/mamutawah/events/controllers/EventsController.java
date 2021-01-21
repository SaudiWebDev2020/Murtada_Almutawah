package com.mamutawah.events.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import com.mamutawah.events.models.Event;
import com.mamutawah.events.models.EventForm;
import com.mamutawah.events.services.LoginService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EventsController {

  private final LoginService loginService;

  public EventsController(LoginService loginService) {
    this.loginService = loginService;
  }

  @RequestMapping("/events")
  public String eventHome(@ModelAttribute("eventForm") EventForm eventForm, HttpSession session, Model model) {
    if (session.getAttribute("userId") == null) {
      return "redirect:/";
    }
    model.addAttribute("myAccount", loginService.getUserById((Long) session.getAttribute("userId")));
    model.addAttribute("states", loginService.getAll());
    model.addAttribute("inStateEvents", loginService.getAllEventInMyState((Long) session.getAttribute("userId")));
    model.addAttribute("otherStateEvents", loginService.getAllEventInOtherState((Long) session.getAttribute("userId")));
    return "/events/index.jsp";
  }

  @RequestMapping(value = "/events", method = RequestMethod.POST)
  public String createEvent(@Valid @ModelAttribute("eventForm") EventForm eventForm, BindingResult result,
      HttpSession session, Model model) {
    // loginService.getById((Long) session.getAttribute("userId"));
    if (result.hasErrors()) {
      model.addAttribute("myAccount", loginService.getUserById((Long) session.getAttribute("userId")));
      model.addAttribute("states", loginService.getAll());
      model.addAttribute("inStateEvents", loginService.getAllEventInMyState((Long) session.getAttribute("userId")));
      model.addAttribute("otherStateEvents",
          loginService.getAllEventInOtherState((Long) session.getAttribute("userId")));
      return "/events/index.jsp";
    }

    loginService.createEvent((Long) session.getAttribute("userId"), eventForm);
    return "redirect:/events";
  }

  @RequestMapping("/events/{id}")
  public String getEvent(@PathVariable("id") Long id, HttpSession session, Model model) {
    if (session.getAttribute("userId") == null) {
      return "redirect:/";
    }

    model.addAttribute("event", loginService.getEventByID(id));
    return "events/view.jsp";
  }

  @RequestMapping("/events/{id}/edit")
  public String editEvent(@ModelAttribute("eventForm") EventForm eventForm, BindingResult result,
      @PathVariable("id") Long id, Model model, HttpSession session) {
    Event e = loginService.getEventByID(id);
    if (e == null || session.getAttribute("userId") == null) {
      return "redirect:/";
    }

    if (!e.getHost().getId().equals(session.getAttribute("userId"))) {
      return "redirect:/events";
    } else {
      model.addAttribute("states", loginService.getAll());
      model.addAttribute("event", e);
      return "events/edit.jsp";
    }

  }

  @RequestMapping(value = "/events/{id}/edit", method = RequestMethod.POST)
  public String editEvent(@Valid @ModelAttribute("eventForm") EventForm eventForm, BindingResult result,
      @PathVariable("id") Long eventId, HttpSession session, Model model) {
    // loginService.getById((Long) session.getAttribute("userId"));
    if (result.hasErrors()) {
      model.addAttribute("states", loginService.getAll());
      model.addAttribute("event", loginService.getEventByID(eventId));
      return "events/edit.jsp";
    }

    loginService.editEvent((Long) session.getAttribute("userId"), eventId, eventForm);
    return "redirect:/events";
  }

  @RequestMapping(value = "/events/{id}/join", method = RequestMethod.POST)
  public String join(@RequestParam(value = "event_id") Long event_id, HttpSession session) {
    loginService.joinAnEvent((Long) event_id, (Long) session.getAttribute("userId"));
    System.out.println("Joining ! " + event_id);

    return "redirect:/events";
  }

  @RequestMapping(value = "/events/{id}/leave", method = RequestMethod.DELETE)
  public String leave(@PathVariable("id") Long event_id, HttpSession session) {
    loginService.leaveAnEvent((Long) event_id, (Long) session.getAttribute("userId"));
    System.out.println("Leave ! " + event_id);
    return "redirect:/events";
  }

  @RequestMapping(value = "/events/{id}", method = RequestMethod.DELETE)
  public String destroy(@PathVariable("id") Long event_id, HttpSession session) {
    loginService.removeAnEvent((Long) event_id, (Long) session.getAttribute("userId"));
    System.out.println("Delete !");
    return "redirect:/events";
  }
}
