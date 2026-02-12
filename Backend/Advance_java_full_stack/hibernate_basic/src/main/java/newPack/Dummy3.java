package newPack;
import javax.persistence.*;
public class Dummy3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		
		//EntityTransaction
		EntityTransaction et=em.getTransaction();
		
		
		Student student=em.find(Student.class,2);
		
		if(student!=null) {
			student.setDob("12-05-2004");
			et.begin();
			em.merge(student);
			et.commit();
			
			emf.close();
		}

	}

}
