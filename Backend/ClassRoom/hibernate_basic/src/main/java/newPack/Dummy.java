package newPack;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.*;

public class Dummy {

	public static void main(String[] args) {
		
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		
		//EntityTransaction
		EntityTransaction et=em.getTransaction();
		
		Student s=new Student();
		s.setId(2);
		s.setName("Rohit");
		s.setPercentage(80);
		
		et.begin();
		em.persist(s);
		et.commit();
		
		emf.close();
	}

}
