package com.product;
import javax.persistence.*;
public class PersonDao {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
    private static EntityManager em = emf.createEntityManager();

    public void insertProduct(Person p) {

        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(p); 
        et.commit();
    }

    public Person findById(int id) {

    	Person p=em.find(Person.class, id);
        return p;
    }

    public boolean deleteProduct(int id) {

    	Person p = findById(id);


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
