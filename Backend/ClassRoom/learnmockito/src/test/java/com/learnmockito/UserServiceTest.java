package com.learnmockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.basics.Calculator;
import com.basics.MathService;
import com.basics.UserDao;
import com.basics.UserService;

public class UserServiceTest {
	
	@Test
	public void testGetTypeOfUser() {
		UserDao ud = new UserDao();
		UserService us = new UserService(ud);
		String actual=us.typeOfUser(1);
		assertEquals("New User",actual);
	}
	
	@Test
	public void testDoubleAddition() {
		
		// Step 1: createFakeObject
		// Create a mock object of the class that needs to be Fake
		Calculator c_mock = mock(Calculator.class);
		
		// Step 2: what mock object should return
		when(c_mock.add(10, 20)).thenReturn(35);
		
		// Step 3: give the fake object reference
		MathService m = new MathService(c_mock);
		
		int res = m.doubleAddition(10, 20);
		
		assertEquals(35,res);
		
	}
}
