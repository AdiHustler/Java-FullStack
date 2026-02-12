package com.prac;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class calculatorTest {
	public void addTest() {
		int res=Calculator.sum(10,30);
	}
	
	@Test
	public void reverseTest() {
		String actual=Calculator.reverseString("data");
		String actualRes=Calculator.reverseString(null);
		// assertEquals matches that assertEquals(expectedResult,actualReslt) are equal
		assertEquals("atad",actual);
		assertEquals("llun",actualRes);
	}
	
	@Test
	public void factorialTest() {
		
	}
	
	@Test
	public void palindromeTest() {
		
	}
	
	@Test
	public void employeeTest() {
		
	}
	
	@Test
	public void testValidAge() {
		Employee e=new Employee(10,"Dinga",20,"CSE");
		
		assertTrue(e.isValidAge());
	}
	
	@Test
	public void testDivide() {
		
		assertThrows(ArithmeticException.class,Calculator.div(10, 0));
	}
	
}
