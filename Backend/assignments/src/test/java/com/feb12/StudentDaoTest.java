package com.feb12;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.jupiter.api.*;

import com.assignment_12Feb2026.Student;
import com.assignment_12Feb2026.StudentDao;



class StudentDaoTest {
    private static EntityManagerFactory emf;
    private EntityManager em;
    private StudentDao dao;
    
    
    @BeforeAll
    static void setUpFactory() {
        emf = Persistence.createEntityManagerFactory("test-unit");
    }
    @AfterAll
    static void closeFactory() {
        if (emf != null) {
            emf.close();
        }
    }
    @BeforeEach
    void setUp() {
        em = emf.createEntityManager();
        dao = new StudentDao(em);
    }

    @AfterEach
    void tearDown() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }
    @Test
    void testSaveStudent() {
        Student s = new Student();
        s.setName("John");
        s.setMarks(85);

        dao.saveStudent(s);

        assertNotNull(s.getId());
    }

    @Test
    void testFindStudentById() {
        Student s = new Student();
        s.setName("Alice");
        s.setMarks(90);
        dao.saveStudent(s);

        Student found = dao.findStudentById(s.getId());

        assertNotNull(found);
        assertEquals("Alice", found.getName());
    }

    @Test
    void testFindAllStudents() {
        Student s1 = new Student();
        s1.setName("A");
        s1.setMarks(70);

        Student s2 = new Student();
        s2.setName("B");
        s2.setMarks(88);

        dao.saveStudent(s1);
        dao.saveStudent(s2);

        List<Student> students = dao.findAllStudent();

        assertTrue(students.size() >= 2);
    }

    @Test
    void testUpdateStudent() {
        Student s = new Student();
        s.setName("Old");
        s.setMarks(60);
        dao.saveStudent(s);

        s.setName("Updated");
        dao.updateStudent(s);

        Student updated = dao.findStudentById(s.getId());

        assertEquals("Updated", updated.getName());
    }

    @Test
    void testDeleteStudent() {
        Student s = new Student();
        s.setName("DeleteMe");
        s.setMarks(50);
        dao.saveStudent(s);

        dao.deleteStudent(s.getId());

        Student deleted = dao.findStudentById(s.getId());

        assertNull(deleted);
    }
    
    @Test
    void testMarksValidation() {
        Student s = new Student();

        try {
            s.setMarks(150);   // invalid marks
            fail("Marks validation failed");
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    void testStudentCount() {
        int before = dao.getStudentCount();

        Student s = new Student();
        s.setName("CountTest");
        s.setMarks(77);
        dao.saveStudent(s);

        int after = dao.getStudentCount();

        assertEquals(before + 1, after);
    }
    
    @Test
    void testFindStudentsWithMarksGreaterThan80() {
    		Student s1 = new Student();
        s1.setName("Topper");
        s1.setMarks(95);

        Student s2 = new Student();
        s2.setName("Low");
        s2.setMarks(60);

        dao.saveStudent(s1);
        dao.saveStudent(s2);

        List<Student> result = dao.findStudentsWithMarksGreaterThan80();

        assertEquals(1, result.size());
        assertEquals("Topper", result.get(0).getName());
    }
}
