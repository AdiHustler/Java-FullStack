package com.CrmAssesment;
import javax.persistence.*;
import java.util.*;

public class ServiceLayer {

    private EntityManager em;

    public ServiceLayer(EntityManager em) {
        this.em = em;
    }

    
    public void registerCustomer(String name, String email, String phone) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Customer c = new Customer();
        c.setName(name);
        c.setEmail(email);
        c.setPhone(phone);

        em.persist(c);

        tx.commit();
    }

    
    public void addAddressToCustomer(Long customerId, Address address) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Customer c = em.find(Customer.class, customerId);
        c.setAddress(address);

        em.persist(address);
        em.merge(c);

        tx.commit();
    }

    
    public void createLead(String source, String status, Long customerId) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Customer c = em.find(Customer.class, customerId);

        Lead l = new Lead();
        l.setSource(source);
        l.setStatus(status);
        l.setCustomer(c);

        em.persist(l);

        tx.commit();
    }

  
    public void assignLeadToEmployee(Long leadId, Long employeeId) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Lead l = em.find(Lead.class, leadId);
        SalesEmployee emp = em.find(SalesEmployee.class, employeeId);

        l.setEmployee(emp);

        em.merge(l);

        tx.commit();
    }

    
    public void convertLeadToCustomer(Long leadId) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Lead l = em.find(Lead.class, leadId);

        Customer c = new Customer();
        c.setName("garv");
        c.setEmail("garv@gmail.com");
        c.setPhone("8194555555");

        em.persist(c);

        l.setCustomer(c);

        tx.commit();
    }

    
    public void addProduct(String name, double price) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Product p = new Product();
        p.setProductName(name);
        p.setPrice(price);

        em.persist(p);

        tx.commit();
    }

   
    public void placeOrder(Long leadId, List<Long> productIds) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Lead lead = em.find(Lead.class, leadId);

        List<Product> products = new ArrayList<>();
        double total = 0;

        for (Long id : productIds) {
            Product p = em.find(Product.class, id);
            products.add(p);
            total += p.getPrice();
        }

        Order order = new Order();
        order.setLead(lead);
        order.setProducts(products);
        order.setOrderDate("today");
        order.setTotalAmount(total);

        em.persist(order);

        tx.commit();
    }

  
    public void raiseTicket(Long orderId, String issueDescription) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        Order order = em.find(Order.class, orderId);

        SupportTicket ticket = new SupportTicket();
        ticket.setOrder(order);
        ticket.setIssue(issueDescription);
        ticket.setStatus("OPEN");

        em.persist(ticket);

        tx.commit();
    }

    public void getEmployeePerformance(Long employeeId) {
        String jpql = "SELECT COUNT(l) FROM Lead l WHERE l.employee.empId = :id";

        Long count = em.createQuery(jpql, Long.class)
                       .setParameter("id", employeeId)
                       .getSingleResult();

        System.out.println("Total Leads: " + count);
    }
}