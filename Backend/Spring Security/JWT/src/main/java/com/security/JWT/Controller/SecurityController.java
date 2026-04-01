package com.security.JWT.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.security.JWT.Util.JWTUtil;


@RestController
public class SecurityController {
	
	@Autowired
	JWTUtil util;
	
	@GetMapping("/{username}")
	public String user(@PathVariable String username) {
		return util.createToken(username);
	}
	
	@GetMapping("/get-user/{token}")
	public String getUsername(@PathVariable String token) {
		return util.getUsername(token);
	} 
	
	@GetMapping("/validate/{username}/{token}")
	public boolean validateToken(@PathVariable String username,@PathVariable String token) {
		return util.validateToken(username,token);
	}
}
