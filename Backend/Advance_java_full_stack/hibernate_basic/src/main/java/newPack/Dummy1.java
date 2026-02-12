package newPack;
import javax.persistence.*;
public class Dummy1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		
		//EntityTransaction
		EntityTransaction et=em.getTransaction();
		
		Student student=em.find(Student.class, 1);
//		em.find(Student.class, 2);
		
		System.out.println(student.getId()+" "+student.getName()+" "+student.getPercentage());

	}

}
