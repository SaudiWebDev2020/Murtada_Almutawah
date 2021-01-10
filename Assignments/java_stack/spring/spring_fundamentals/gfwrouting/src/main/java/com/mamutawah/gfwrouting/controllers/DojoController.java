package com.mamutawah.gfwrouting.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DojoController {
	
	@GetMapping("/{name}")
	public String name(@PathVariable("name") String name) {
		return String.format("The %s is awesome!", name); 
	}
	
	@GetMapping("/burbank-dojo/")
	public String burbank() {
		return String.format("Burbank Dojo is located in Southern California"); 
	}
	
	@GetMapping("/san-jose/")
	public String headquarters() {
		return String.format("SJ dojo is the headquarters"); 
	}
}
