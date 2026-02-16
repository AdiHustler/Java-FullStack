package com.learnmockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.basics.Calculator;
import com.basics.MathService;
import com.basics.User;
import com.basics.UserDao;
import com.basics.UserService;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock
	UserDao daoMock;
	
	@InjectMocks
	UserService service;
	
	
	@Test
	public void testGetTypeOfUser() {
		User fakeUser1 = new User();
		fakeUser1.setId(1);
		fakeUser1.setBalance(5000);
		fakeUser1.setName("Billo");
		when(UserDao.findById(1)).thenReturn(fakeUser1);

//		UserDao ud = new UserDao();
//		UserService us = new UserService(ud);
		String actual=service.typeOfUser(1);
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
