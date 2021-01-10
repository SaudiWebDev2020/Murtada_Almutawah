package com.mamutawah.hellohuman.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	
	@GetMapping("/")
	public String index(@RequestParam(value="name", required=false) String name, @RequestParam(value="last_name", required=false) String last_name) {
		String str = "";
		if (name == null) {
			name = "Human";
		} else {
			str = "<a href='http://localhost:8080/'>Go Back</a>";
		}
		
		if(last_name != null) {
			name += ", " + last_name;
		}
		
		str += String.format("<h1>Hello %s!</h1>", name);
		str += "<p>Wellcome to SpringBoot!</p>";
		
		return str;
	}
	
}
