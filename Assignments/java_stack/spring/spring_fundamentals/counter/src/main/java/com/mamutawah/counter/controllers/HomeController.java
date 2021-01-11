package com.mamutawah.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);			
		}		
		Integer count = (Integer) session.getAttribute("count") + 1;
		session.setAttribute("count",count);
		System.out.println(session.getAttribute("count"));
		return "index.jsp";
	}

	@RequestMapping("/counter")
	public String counter(Model model, HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);			
		}
		model.addAttribute("counter", session.getAttribute("count"));
		return "counter.jsp";
	}
	
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("count", 0);
		return "redirect:/counter";
	}
	
	@RequestMapping("/double")
	public String doubleCount(Model model, HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);			
		}		
		Integer count = (Integer) session.getAttribute("count") + 2;
		session.setAttribute("count",count);
		return "double.jsp";
	}
	
	
	

}
