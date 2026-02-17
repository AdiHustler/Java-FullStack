package com.weekly_CaseStudy3;

import java.util.List;
import javax.persistence.*;

public class CourseDAO {

    EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveCourse(Course c) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(c);
        tx.commit();

        em.close();
    }

    public Course findCourse(long id) {

        EntityManager em = emf.createEntityManager();
        Course c = em.find(Course.class, id);

        em.close();
        return c;
    }

    public List<Course> findByInstructor(long instructorId) {

        EntityManager em = emf.createEntityManager();
        Instructor i = em.find(Instructor.class, instructorId);

        List<Course> list = null;

        if (i != null) {
            list = i.getCourses();
            list.size();
        }

        em.close();
        return list;
    }
}
