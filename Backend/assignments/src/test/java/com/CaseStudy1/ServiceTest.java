package com.CaseStudy1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.weekly_CaseStudy1.OrderDao;
import com.weekly_CaseStudy1.Payment;
import com.weekly_CaseStudy1.PaymentDao;
import com.weekly_CaseStudy1.Profile;
import com.weekly_CaseStudy1.PurchaseOrder;
import com.weekly_CaseStudy1.Service;
import com.weekly_CaseStudy1.User;
import com.weekly_CaseStudy1.UserDao;

public class ServiceTest {
	private static EntityManagerFactory emf;
    private static Service service;

    @BeforeAll
    static void setup() {

        emf = Persistence.createEntityManagerFactory("postgres");

        UserDao userDAO = new UserDao();
        OrderDao orderDAO = new OrderDao();
        PaymentDao paymentDAO = new PaymentDao();

        service = new Service(userDAO, orderDAO, paymentDAO);
    }

    @AfterAll
    static void tearDown() {
        emf.close();
    }

    @Test
    void testRegisterUser() {
        Profile profile = new Profile();
        profile.setPhone(999999999);
        profile.setAddress("Delhi");

        User user = new User();
        user.setName("Aditya");
        user.setEmail("adi@gmail.com");
        user.setP(profile);

        service.registerUser(user);

        assertNotNull(user.getId());
    }

    @Test
    void testAddOrders() {
        PurchaseOrder order1 = new PurchaseOrder();
        order1.setOrderDate(new Date());
        order1.setTotal(1000);

        PurchaseOrder order2 = new PurchaseOrder();
        order2.setOrderDate(new Date());
        order2.setTotal(2000);

        List<PurchaseOrder> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);

        service.addOrders(1L, orders);

        User user = service.fetchUser(1L);
        assertFalse(user.getPurchase().isEmpty());
    }

    @Test
    void testAddPayment() {
        PurchaseOrder order = service.fetchUser(1L).getPurchase().get(0);

        Payment payment = new Payment();
        payment.setMode("UPI");
        payment.setAmount(order.getTotal());
        payment.setPurchase(order);

        service.addPayment(payment);

        assertNotNull(payment.getId());
    }

    @Test
    void testFetchUser() {
        User user = service.fetchUser(1L);

        assertNotNull(user);
        assertNotNull(user.getPurchase());
    }

    @Test
    void testUpdateOrderAmount() {
        User user = service.fetchUser(1L);
        PurchaseOrder order = user.getPurchase().get(0);

        order.setTotal(5000);
        service.updateOrderAmount(order);

        PurchaseOrder updated =
                service.fetchUser(1L).getPurchase().get(0);

        assertEquals(5000.0, updated.getTotal());
    }

    @Test
    void testDeleteUser() {
        service.deleteUser(1L);

        User user = service.fetchUser(1L);
        assertNull(user);
    }

}
