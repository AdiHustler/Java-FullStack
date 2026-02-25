package com.capgemini.SpringBoot_Basic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * @SpringBootApplication => @ComponentScan + @EnableAutoConfiguration + @Configuration.
 * This is the entry point of the project.
 */
@SpringBootApplication
public class SpringBootBasicApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicApplication.class, args);
		
		
	}

}
