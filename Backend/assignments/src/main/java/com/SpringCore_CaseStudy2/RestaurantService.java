package com.SpringCore_CaseStudy2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RestaurantService {

    private DeliveryService deliveryService;

    @Autowired
    public void setDeliveryService(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    public void processOrder() {
        System.out.println("Restaurant khana bna rha hai...");
        deliveryService.deliverOrder();
    }
}