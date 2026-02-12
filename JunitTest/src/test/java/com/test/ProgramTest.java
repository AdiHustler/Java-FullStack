package com.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import com.testing.Program;

public class ProgramTest {
	
	@ParameterizedTest
	@ValueSource(strings= {"billo","sanda","radar"})
	public void isPalindromeTest(String str) {
		Program p = new Program();
		assertTrue(p.isPalindrome(str));
	}
	@ParameterizedTest
	@ValueSource(ints= {-1,4,22,69,-88})
	public void isPositiveTest(int n) {
		Program p = new Program();
		assertTrue(p.isPositive(n));
	}
	
	@ParameterizedTest
	@CsvSource({"1,2,3","4,5,9"})
	public void addTest(int a, int b, int expectedResult) {
		Program p=new Program();
		assertEquals(expectedResult,p.add(a,b));
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/JunitTest.csv", numLinesToSkip=1)
	public void evenoddTest(String input,String expected) {
		Program p=new Program();
		String actual=p.isEven(Integer.parseInt(input));
		assertEquals(expected,actual);
	}
}
