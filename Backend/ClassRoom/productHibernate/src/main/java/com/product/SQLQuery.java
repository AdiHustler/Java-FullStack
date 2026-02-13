package com.product;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class SQLQuery {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	    EntityManager em = emf.createEntityManager();
	    EntityTransaction et = em.getTransaction();
	    
	    
//	    String sql="UPDATE PRODUCT SET PRICE=?1 WHERE PRICE>=2";
//	    Query query = em.createNativeQuery(sql);
//	    query.setParameter(1, 15.0);
//	    query.setParameter(2, 10.0);
	    
	    String sql="SELECT p FROM Product p where p.price>:a and p.quantity>:b";
	    Query query = em.createNativeQuery(sql);
	    query.setParameter("a", 5.0);
	    query.setParameter("b", 0);
	    
	    query.executeUpdate();
	    et.commit();
	    
//	    List<Product> list = query.getResultList();
//	    
//	    System.out.println(list);

	}

}
