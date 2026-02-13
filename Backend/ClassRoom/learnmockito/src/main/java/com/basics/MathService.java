package com.basics;

public class MathService {
	Calculator c;
	public MathService(Calculator c){
		this.c=c;
	}
	public int doubleAddition(int a,int b) {
		return 2*c.add(a,b);
	}
}
