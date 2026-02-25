package com.SpringCore_CaseStudy2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp2 {
	public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        OrderService orderService = context.getBean(OrderService.class);
        orderService.placeOrder();

        context.close();
    }
}
