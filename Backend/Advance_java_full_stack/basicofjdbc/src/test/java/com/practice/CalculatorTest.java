package com.practice;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
	public void addTest() {
		int res = Calculator.add(20,30);
	}
	@Test
	public void reverseTest() {
		String actualres = Calculator.reverseString("data");
		
		assertEquals("atad",actualres);
	}
	@Test
	public void reverseTestNull() {
		String actualRes = Calculator.reverseString("null");
		assertEquals("llun",actualRes);
	}
	@Test
	public void factorialTest() {
		int actualres=Calculator.factorial(10);
		assertEquals(0,actualres);
	}
	
	@Test
	public void palindromeTest() {
		Boolean actualres=Calculator.palindrom("abccba");
		assertEquals(true,actualres);
	}
	@Test
	public void testValidAge() {
		Employee e=new Employee(10,"Allen",18,"CSE");
		assertTrue(e.isValidAge());
	}
	
	@Test
	public void testAEEx() {
		Calculator c=new Calculator();
		assertThrows(ArithmeticException.class,()->{c.div(10, 0);});
	}
	
	
}