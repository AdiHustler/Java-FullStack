package com.basic1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.basic1.prac.CreditCard;
import com.basic1.prac.Payment;
import com.basic1.prac.UPI;

@Configuration
@ComponentScan(basePackages="com")
public class DemoConfiguration {
}