package com.CaseStudy;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class OrderAnalytics {
	
	public static List<Order> getPaidOrders(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getStatus().equals("PAID"))
                .toList();
    }

    public static long countOrders(List<Order> orders) {
        return orders.stream().count();
    }

    public static double totalPaidRevenue(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getStatus().equals("PAID"))
                .mapToDouble(Order::getAmount)
                .sum();
    }

    public static Optional<Order> highestOrder(List<Order> orders) {
        return orders.stream()
                .max(Comparator.comparingDouble(Order::getAmount));
    }

    public static Optional<Order> lowestPaidOrder(List<Order> orders) {
        return orders.stream()
                .filter(o -> o.getStatus().equals("PAID"))
                .min(Comparator.comparingDouble(Order::getAmount));
    }

    // Customer Insights
    public static List<String> uniqueCustomers(List<Order> orders) {
        return orders.stream()
                .map(Order::getCustomerName)
                .distinct()
                .toList();
    }

    public static List<Order> top3Orders(List<Order> orders) {
        return orders.stream()
                .sorted(Comparator.comparingDouble(Order::getAmount).reversed())
                .limit(3)
                .toList();
    }

    // Category Analytics
    public static Map<String, Long> countPerCategory(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCategory,
                        Collectors.counting()));
    }

    public static Map<String, Double> totalSalesPerCategory(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.groupingBy(
                        Order::getCategory,
                        Collectors.summingDouble(Order::getAmount)));
    }

    // Partitioning
    public static Map<Boolean, List<Order>> partitionPaid(List<Order> orders) {
        return orders.stream()
                .collect(Collectors.partitioningBy(
                        o -> o.getStatus().equals("PAID")));
    }

    // Advanced
    public static Optional<Double> secondHighestAmount(List<Order> orders) {
        return orders.stream()
                .map(Order::getAmount)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
    }

    public static boolean cancelledAbove50k(List<Order> orders) {
        return orders.stream()
                .anyMatch(o -> o.getStatus().equals("CANCELLED")
                        && o.getAmount() > 50000);
    }
    
}
