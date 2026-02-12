package newPack;
import javax.persistence.*;
public class Dummy2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		
		//EntityTransaction
		EntityTransaction et=em.getTransaction();
		
		
		Student student=em.find(Student.class,1);
		
		et.begin();
		em.remove(student);
		et.commit();
		
		emf.close();
	}

}
