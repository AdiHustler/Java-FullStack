package com.capgemini.SpringBoot_Basic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	
	@Autowired
	private HumanRepositry human;
	
	@GetMapping("/home")
	public List<String> greet() {
		return List.of("Namastute!");
	}
	
	@GetMapping("/add")
	public void addCustomer(@RequestBody Human h) {
		
	}
	
	
}
