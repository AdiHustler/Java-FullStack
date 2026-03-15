package com.SmartRecharge.notificationservice.service;

import org.springframework.stereotype.Service;

import com.SmartRecharge.notificationservice.exception.NotificationException;

@Service
public class EmailSenderService {
    public void send(String email, String subject, String body) throws NotificationException {
    }
}
