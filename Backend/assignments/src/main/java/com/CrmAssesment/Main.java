package com.CrmAssesment;

import javax.persistence.*;
import java.util.*;
public class Main {

    public static void main(String[] args) {

        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();

        Scanner sc = new Scanner(System.in);

        ServiceLayer service = new ServiceLayer(em);

        int choice;

        while (true) {

            System.out.println("\n===== CRM MENU =====");
            System.out.println("1. Register Customer");
            System.out.println("2. Add Address to Customer");
            System.out.println("3. Create Lead");
            System.out.println("4. Assign Lead to Employee");
            System.out.println("5. Convert Lead to Customer");
            System.out.println("6. Add Product");
            System.out.println("7. Place Order");
            System.out.println("8. Raise Ticket");
            System.out.println("9. Employee Performance");
            System.out.println("10. Exit");

            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    service.registerCustomer("Garv", "garv@gmail.com", "9999999999");
                    break;

                case 2:
                    Address address = new Address();
                    address.setCity("Delhi");
                    address.setState("Delhi");
                    address.setPincode("110001");

                    service.addAddressToCustomer(1L, address);
                    break;

                case 3:
                    service.createLead("Website", "NEW", 1L);
                    break;

                case 4:
                    service.assignLeadToEmployee(1L, 1L);
                    break;

                case 5:
                    service.convertLeadToCustomer(1L);
                    break;

                case 6:
                    service.addProduct("Laptop", 50000);
                    break;

                case 7:
                    List<Long> productIds = Arrays.asList(1L);
                    service.placeOrder(1L, productIds);
                    break;

                case 8:
                    service.raiseTicket(1L, "Issue with product");
                    break;

                case 9:
                    service.getEmployeePerformance(1L);
                    break;

                case 10:
                    em.close();
                    emf.close();
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}