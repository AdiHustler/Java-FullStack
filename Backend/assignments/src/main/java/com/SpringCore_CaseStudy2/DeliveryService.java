package com.SpringCore_CaseStudy2;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class DeliveryService {
		
	public DeliveryService() {
        System.out.println("DeliveryService Bean Created");
    }

    @PostConstruct
    public void init() {
        System.out.println("Delivery Service Ready");
    }
    
    public void deliverOrder() {
    	System.out.println("Order Delivered Successfully");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Delivery Service Closed");
    }
}
