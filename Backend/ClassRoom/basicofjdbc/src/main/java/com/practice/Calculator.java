package com.practice;

public class Calculator {
	public static int add(int a,int b) {
		return a+b;
	}
	public static String reverseString(String data) {
		String rev="";
		for(int i=data.length()-1;i>=0;i--) {
			rev=rev+data.charAt(i);
		}
		return rev;
	}
	public static int factorial(int n) {
		int pro=1;
		for(int i=1;i<n;i++) {
			if(n%i==0) {
				pro*=i;
			}
		}
		return pro;
	}
	public static boolean palindrom(String str) {
		int i=0;
		int j=str.length()-1;
		while(i<j) {
			if(str.charAt(i)!=str.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static int div(int a,int b) {
		return a/b;
		
	}
}
