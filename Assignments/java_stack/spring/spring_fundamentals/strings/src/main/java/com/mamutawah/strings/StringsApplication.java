package com.mamutawah.strings;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StringsApplication {

	public static void main(String[] args) {
		SpringApplication.run(StringsApplication.class, args);
	}
	
	@GetMapping("/")
	public String index() {
		return "Hello client! How are you doing?";
	}

	
	@GetMapping("/random")
	public String random() {
		return "Spring Boot is great! So easy to just response with strings";
	}
}
