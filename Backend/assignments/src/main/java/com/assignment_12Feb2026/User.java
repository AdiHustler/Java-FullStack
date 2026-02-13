package com.assignment_12Feb2026;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class User {

    public static void main(String[] args) {

        EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");

        // Save Student
        EntityManager em1 = emf.createEntityManager();
        StudentDao dao1 = new StudentDao(em1);

        Student s = new Student();
        s.setId(1);
        s.setName("Rahul");
        s.setEmail("rahul1@gmail.com");
        s.setMarks(85);

        dao1.saveStudent(s);
        System.out.println("Saved Student ID: " + s.getId());


        // Find By Id
        EntityManager em2 = emf.createEntityManager();
        StudentDao dao2 = new StudentDao(em2);

        Student found = dao2.findStudentById(s.getId());
        System.out.println("Found Student: " + found.getName());


        // Update Student
        EntityManager em3 = emf.createEntityManager();
        StudentDao dao3 = new StudentDao(em3);

        found.setMarks(95);
        dao3.updateStudent(found);
        System.out.println("Student Updated");


        // Find All Students
        EntityManager em4 = emf.createEntityManager();
        StudentDao dao4 = new StudentDao(em4);

        List<Student> allStudents = dao4.findAllStudent();

        System.out.println("All Students:");
        for (Student st : allStudents) {
            System.out.println(st.getId() + " " + st.getName() + " " +st.getEmail() + " " + st.getMarks());
        }


        // Count Students
        EntityManager em5 = emf.createEntityManager();
        StudentDao dao5 = new StudentDao(em5);

        int count = dao5.getStudentCount();
        System.out.println("Total Students: " + count);

        // Custom Query (marks > 80)
        EntityManager em6 = emf.createEntityManager();
        StudentDao dao6 = new StudentDao(em6);

        List<Student> toppers = dao6.findStudentsWithMarksGreaterThan80();

        System.out.println("Students with marks > 80:");
        for (Student st : toppers) {
            System.out.println(st.getName());
        }

        
        // Delete
        EntityManager em7 = emf.createEntityManager();
        StudentDao dao7 = new StudentDao(em7);

        dao7.deleteStudent(s.getId());
        System.out.println("Student Deleted");


        emf.close();
    }
}
