package com.prac;

public class Calculator {

	public static int sum(int a, int b) {
		return a+b;
	}
	
	public static String  reverseString(String input) {
		String res="";
		for(int i=input.length()-1;i>=0;i--) {
			res=res+input.charAt(i);
		}
		return res;
	}
	
	
	public static int factorial(int n) {
		if(n==0 || n==1) {
			return 1;
		}
		return n*factorial(n-1);
	}
	
	
	public static boolean palindrome(String input) {
		String res="";
		for(int i=input.length()-1;i>=0;i--) {
			res=res+input.charAt(i);
		}
		return input.equals(res);
	}
	
	public static int div(int a,int b) {
		return a/b;
	}
}
