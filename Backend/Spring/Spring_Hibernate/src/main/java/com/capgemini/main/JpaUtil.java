package com.capgemini.main;

import org.springframework.stereotype.Component;
import javax.persistence.*;


@Component
public class JpaUtil {
	
	@PostConstruct		
	public void display() {
		System.out.println("Display");
	}
	
	@PreDestroy
	public void print() {
		System.out.println("Print");
	}
}
