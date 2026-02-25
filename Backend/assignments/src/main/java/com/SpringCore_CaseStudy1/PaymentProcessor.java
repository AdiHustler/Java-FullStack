package com.SpringCore_CaseStudy1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PaymentProcessor {

    private final Payment paymentService;

    @Autowired
    private TransactionLogger transactionLogger;

    public PaymentProcessor(
            @Qualifier("UPI") Payment paymentService) {
        this.paymentService = paymentService;
    }

    public void makePayment(double amount) {
        transactionLogger.log("Starting transaction...");
        paymentService.processPayment(amount);
    }
}