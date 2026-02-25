package com.SpringCore_CaseStudy1;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UPI implements Payment {

    private final TransactionLogger logger;

    public UPI(TransactionLogger logger) {
        this.logger = logger;
    }

    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI Payment: " + amount);
        logger.log("UPI payment done: " + amount);
    }
}