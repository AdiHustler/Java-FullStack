package com.SpringCore_CaseStudy1;

import javax.annotation.PreDestroy;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Component;



@Component
public class TransactionLogger {

    @PostConstruct
    public void init() {
        System.out.println("Logger initialized");
    }

    public void log(String message) {
        System.out.println("LOG: " + message);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Logger destroyed");
    }
}