package com.capgemini.SpringBoot_Basic;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@GetMapping("/home")
	public List<String> greet() {
		return List.of("Namastute!");
	}
}
