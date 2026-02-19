package com.stream_revision;

import java.util.Map;
import java.util.stream.Collectors;

public class Main2 {
	public static void main(String[] ars) {
		String s = "Hello";
		Map<Object, Long > res = s.chars()
			.mapToObj(i->(char)i)
			.collect(Collectors.groupingBy(c->c,Collectors.counting()));
		
		for(Map.Entry<Object,Long> entry : res.entrySet()) {
			System.out.println(entry.getKey()+": "+entry.getValue());
		}
		System.out.println(res);
	}
}
