package newPack;
import java.util.*;
import javax.persistence.*;
public class Dummy4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("postgres");
		EntityManager em=emf.createEntityManager();
		
		//EntityTransaction
		EntityTransaction et=em.getTransaction();
		
		
		String jpql="Select s from Student s ";
		
		Query query=em.createQuery(jpql);
		
		List<Student> list=query.getResultList();
		list.forEach(System.out::println);
		
//		Student student=em.find(Student.class,2);

	}

}
