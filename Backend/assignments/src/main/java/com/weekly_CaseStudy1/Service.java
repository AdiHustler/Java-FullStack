package com.weekly_CaseStudy1;

import java.util.List;

public class Service {
	
    private UserDao userDAO;
    private OrderDao orderDAO;
    private PaymentDao paymentDAO;

    public Service(UserDao userDAO, OrderDao orderDAO, PaymentDao paymentDAO) {
        this.userDAO = userDAO;
        this.orderDAO = orderDAO;
        this.paymentDAO = paymentDAO;
    }

    // Register User with Profile
    public void registerUser(User user) {
        userDAO.saveUser(user);
    }

    //Add Orders to User
    public void addOrders(Long userId, List<PurchaseOrder> orders) {
        User user = userDAO.findUser(userId);
        user.getPurchase().addAll(orders);
        userDAO.updateUser(user);
    }

    // Add Payment to Order
    public void addPayment(Payment payment) {
        paymentDAO.savePayment(payment);
    }

    // Fetch User with Orders
    public User fetchUser(Long id) {
        return userDAO.findUser(id);
    }

    //Delete User
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    //Update Order Amount
    public void updateOrderAmount(PurchaseOrder order) {
        orderDAO.saveOrder(order);
    }
}
