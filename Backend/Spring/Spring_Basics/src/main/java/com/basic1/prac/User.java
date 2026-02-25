package com.basic1.prac;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.basic1.DemoConfiguration;

@Component
public class User {
	private int id;
	private int amount;
	private String name;
	
	@Autowired
	@Qualifier("creditCard")
	private Payment payment;
	
	public void display() {
		payment.sendConfirmation();
	}
	
	public static void main(String[] args) {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		
		User u = ioc.getBean(User.class);
		
		System.out.println(u);
		
		u.display();
		
	}
}
