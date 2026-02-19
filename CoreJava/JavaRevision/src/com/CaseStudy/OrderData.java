package com.CaseStudy;

import java.util.List;

public class OrderData {
    public static List<Order> getOrders() {
        return List.of(
                new Order(1, "Amit", "Electronics", 75000, "Delhi", "PAID"),
                new Order(2, "Ravi", "Clothing", 2500, "Mumbai", "PENDING"),
                new Order(3, "Neha", "Electronics", 52000, "Delhi", "PAID"),
                new Order(4, "Amit", "Furniture", 45000, "Chandigarh", "PAID"),
                new Order(5, "Simran", "Clothing", 1500, "Delhi", "CANCELLED"),
                new Order(6, "Raj", "Electronics", 99000, "Mumbai", "PAID"),
                new Order(7, "Karan", "Furniture", 65000, "Pune", "PAID"),
                new Order(8, "Neha", "Clothing", 7000, "Delhi", "PAID")
        );
    }
}
