package com.product_hibernate;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.*;
import org.junit.jupiter.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.product.Person;
import com.product.PersonDao;
import com.product.Product;
import com.product.ProductDao;
public class PersonTest {

	
		// TODO Auto-generated method stub\
		
		static EntityManagerFactory emf;
		static EntityManager em;
		@BeforeAll
		public static void initEmf() {
			emf = Persistence.createEntityManagerFactory("postgres");
		}
		@BeforeEach
		public void initEm() {
			em=emf.createEntityManager(); 
		}
		@Test
		public void insertPersonTest() {
			PersonDao dao = new PersonDao();
			Person p = new Person();
			p.setId(1);
			p.setName("Aryan");
			p.setDob("12-05-2004");
			p.setAddress("Bijnor");
			p.setPincode(246701);
			dao.insertProduct(p);
		}
		@Test
		public void findByIdTest() {
			PersonDao dao = new PersonDao();
			Person p = dao.findById(1);
			assertNotNull(p);
		}
		@Test
		public void deletePersonTest() {
			PersonDao dao = new PersonDao(); 
			assertTrue(dao.deleteProduct(1));
		}
		@Test
		public void deleteNoPersonTest() { 
			PersonDao dao = new PersonDao();
			assertTrue(dao.deleteProduct(-5));
		}
		
		@AfterEach
		public void destroyEm() {
			em.close();
		}
		@AfterAll
		public static void destroyEmf() {
			emf.close();
		}
	

}
