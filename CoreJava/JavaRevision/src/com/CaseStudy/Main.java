package com.CaseStudy;

import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		List<Order> orders = OrderData.getOrders();
	
	    System.out.println("Paid Orders:");
	    System.out.println(OrderAnalytics.getPaidOrders(orders));
	
	    System.out.println("Total Orders: " +
	            OrderAnalytics.countOrders(orders));
	
	    System.out.println("Total Revenue: " +
	            OrderAnalytics.totalPaidRevenue(orders));
	
	    System.out.println("Highest Order:");
	    OrderAnalytics.highestOrder(orders)
	            .ifPresent(System.out::println);
	
	    System.out.println("Top 3 Orders:");
	    System.out.println(OrderAnalytics.top3Orders(orders));
	}
}
