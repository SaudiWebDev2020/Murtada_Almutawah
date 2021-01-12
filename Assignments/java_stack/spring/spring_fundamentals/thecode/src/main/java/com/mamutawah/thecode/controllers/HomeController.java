package com.mamutawah.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(value="/code", method=RequestMethod.POST)
	public String verify(@RequestParam(value="code") String code, RedirectAttributes redirectAttributes) {
		if(!code.equals("bushido")) {
			System.out.println(code);
			redirectAttributes.addFlashAttribute("error", "Error: Code is not correct!");
			return "redirect:/";
		}
		
		return "code.jsp";
	}
}
