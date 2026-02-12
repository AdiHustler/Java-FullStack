package com.product;

import javax.persistence.*;

public class ProductDao {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    private static EntityManager em = emf.createEntityManager();

    public void insertProduct(Product p) {

        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(p); 
        et.commit();
    }

    public Product findById(int id) {

        Product p=em.find(Product.class, id);
        return p;
    }

    public boolean deleteProduct(int id) {

    	Product p = findById(id);


        if (p != null) {
        	EntityTransaction et = em.getTransaction();
            et.begin();
            em.remove(p);
            et.commit();
            return true;
        }
        else {
        	return false;
        }
    }

//    public void close() {
//        if (em != null) em.close();
//        if (emf != null) emf.close();
//    }
}
