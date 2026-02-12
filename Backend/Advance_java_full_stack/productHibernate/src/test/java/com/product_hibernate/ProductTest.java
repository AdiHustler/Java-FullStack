package com.product_hibernate;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.product.Product;
import com.product.ProductDao;
public class ProductTest {
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
	public void insertProductTest() {
		ProductDao dao = new ProductDao();
		Product pro = new Product();
		pro.setId(2);
		pro.setName("Pencil");
		pro.setPrice(50);
		pro.setQuantity(10);
		dao.insertProduct(pro);
	}
	@Test
	public void findByIdTest() {
		ProductDao dao = new ProductDao();
		Product p = dao.findById(1);
		assertNotNull(p);
	}
	@Test
	public void deleteProductTest() {
		ProductDao dao = new ProductDao(); 
		assertTrue(dao.deleteProduct(1));
	}
	@Test
	public void deleteNoProductTest() {
		ProductDao dao = new ProductDao();
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