package com.SpringCore_CaseStudy1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp1{

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        PaymentProcessor processor = context.getBean(PaymentProcessor.class);

        processor.makePayment(500);

        context.close();
    }
}