package com.SpringCore_CaseStudy2;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class SmsNotification implements NotificationService{
	
	public SmsNotification() {
        System.out.println("SmsNotification Bean created");
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending SMS: " + message);
    }
}
