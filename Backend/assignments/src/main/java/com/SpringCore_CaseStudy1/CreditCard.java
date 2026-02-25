package com.SpringCore_CaseStudy1;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class CreditCard implements Payment {

    private final TransactionLogger logger;

    public CreditCard(TransactionLogger logger) {
        this.logger = logger;
        System.out.println("CreditCardPayment Bean Created");
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment: " + amount);
        logger.log("Credit Card payment done: " + amount);
    }
}
