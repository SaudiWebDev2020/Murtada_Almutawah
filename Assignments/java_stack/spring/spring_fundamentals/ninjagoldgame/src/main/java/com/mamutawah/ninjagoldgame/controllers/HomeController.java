package com.mamutawah.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpSession;

import com.mamutawah.ninjagoldgame.models.Activity;
import com.mamutawah.ninjagoldgame.models.Place;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

  private ArrayList<Place> getPlaces() {
    ArrayList<Place> places = new ArrayList<Place>();

    places.add(new Place(1, "Farm", true, false, 10, 20));
    places.add(new Place(2, "Cave", true, false, 5, 10));
    places.add(new Place(3, "House", true, false, 2, 5));
    places.add(new Place(4, "Casino!", true, true, 0, 50));
    places.add(new Place(5, "Spa", false, true, 5, 20));
    places.add(new Place(6, "Big Win", true, false, 5, 100));

    return places;
  }

  @GetMapping("/")
  public String index() {
    return "index.jsp";
  }

  @GetMapping("/gold")
  public String gold(HttpSession session, Model model) {
    if (session.getAttribute("balance") == null) {
      session.setAttribute("balance", 0);
    }

    if ((int) session.getAttribute("balance") < -100) {
      return "redirect:/prison";
    }

    // System.out.println(session.getAttribute("activities"));

    model.addAttribute("balance", session.getAttribute("balance"));
    model.addAttribute("places", getPlaces());
    model.addAttribute("activities", session.getAttribute("activities"));
    return "gold.jsp";
  }

  @PostMapping(value = "/process_find")
  public String find(HttpSession session, @RequestParam(value = "place_id") int place_id) {
    if (session.getAttribute("balance") == null) {
      session.setAttribute("balance", 0);
    }

    if (session.getAttribute("activities") == null) {
      session.setAttribute("activities", new ArrayList<Activity>());
    }

    SimpleDateFormat sf = new SimpleDateFormat("MMMM dd YYYY k:mm a");
    Place findInPlace = getPlaces().get(((int) place_id) - 1);
    int find = findInPlace.find();
    Integer balance = (Integer) session.getAttribute("balance") + find;

    ArrayList<Activity> activities = (ArrayList<Activity>) session.getAttribute("activities");

    if (find < 0) {
      activities.add(0, new Activity("lose", String.format("Entered a %s and lost %d golds... Ouch..(%s)",
          findInPlace.getName(), Math.abs(find), sf.format(new Date()))));
    } else {
      activities.add(0, new Activity("win", String.format("Earned %d golds from the %s! (%s)", Math.abs(find),
          findInPlace.getName(), sf.format(new Date()))));
    }

    session.setAttribute("activities", activities);
    session.setAttribute("balance", balance);

    return "redirect:/gold";
  }

  @GetMapping(value = "/reset")
  public String reset(HttpSession session) {
    session.setAttribute("balance", 0);
    session.setAttribute("activities", new ArrayList<Activity>());

    return "redirect:/gold";
  }

  @GetMapping(value = "/prison")
  public String prison() {
    return "prison.jsp";
  }

}