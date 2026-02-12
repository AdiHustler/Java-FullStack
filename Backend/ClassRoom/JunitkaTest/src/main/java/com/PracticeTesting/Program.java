package com.PracticeTesting;

public class Program {
	
	public boolean isPalindrome(String s) {
		StringBuilder str=new StringBuilder(s);
		str=str.reverse();
		return s.equals(str.toString());
	}
	
	public boolean isPositive(int n) {
		return n>=0;
	}
	
	public int add(int a,int b) {
		return a+b;
	}
	
	public String isEvenOrOdd(int n) {
		return (n%2==0)?"even":"odd";
	}
}
