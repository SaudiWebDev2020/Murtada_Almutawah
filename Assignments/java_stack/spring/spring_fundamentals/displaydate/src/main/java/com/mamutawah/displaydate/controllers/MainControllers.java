package com.mamutawah.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainControllers {

	@GetMapping("/")
    public String index() {
        return "index.jsp";
    }
	
	@GetMapping("/date")
    public String date(Model model) {
		model.addAttribute("date", new SimpleDateFormat("EEEE, 'the' dd 'of' MMMM, YYYY").format(new Date()));
        return "date.jsp";
    }
	
	@GetMapping("/time")
    public String time(Model model) {
		model.addAttribute("time", new SimpleDateFormat("h:mm a").format(new Date()));
        return "time.jsp";
    }
}
