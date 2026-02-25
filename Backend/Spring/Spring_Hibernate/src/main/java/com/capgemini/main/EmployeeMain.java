package com.capgemini.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.ProjectConfiguration;

public class EmployeeMain {
	public static void main(String[] args) {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		
		
	}
}
