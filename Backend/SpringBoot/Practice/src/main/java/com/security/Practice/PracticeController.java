package com.security.Practice;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/practices")
public class PracticeController {
	
	@GetMapping
	public String getDetails() {
		return "Details";
	}
	
	@DeleteMapping
	public String deleteUser() {
		return "Delete";
	}
}
