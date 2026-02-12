package com.Test;
import com.PracticeTesting.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
public class ProgramTest {
	
		// TODO Auto-generated method stub
		@ParameterizedTest
		@ValueSource(strings= {"tenet","radar","aba"})
		public void isPalindromeTest(String str) {
			Program p=new Program(); 
			assertTrue(p.isPalindrome(str));	
		}
		
		@ParameterizedTest
		@ValueSource(ints = {1,2,-23,-54,99})
		public void isPositiveTest(int n) {
			Program p=new Program(); 
			assertTrue(p.isPositive(n));	
		}
		
		@ParameterizedTest
		@CsvSource({
			"1,2,3",
			"5,5,10",
			"5,3,8"
		})
		public void addTest(int a,int b,int expectedResult) {
			Program p=new Program();
			int actualres=p.add(a,b);
			assertEquals(expectedResult,actualres);
		}
		
		
		@ParameterizedTest
		@CsvFileSource(resources="/junitTestExcel.csv",numLinesToSkip=1)
		public void EvenOddTest(String input,String expected) {
			Program p=new Program();
			String actualres=p.isEvenOrOdd(Integer.parseInt(input));
			assertEquals(expected,actualres);
			
		}
		
		

}
