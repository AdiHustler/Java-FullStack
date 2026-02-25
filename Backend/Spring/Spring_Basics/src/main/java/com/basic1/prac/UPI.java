package com.basic1.prac;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UPI implements Payment{
    private int amount;
    private String name;

    public UPI(@Value("100")int amount,@Value("Adam") String name) {
        this.amount = amount;
        this.name = name;
    }

    @Override
    public void sendConfirmation() {
        System.out.println("Payment confirmed for " + name +" from UPI.");
    }
}
