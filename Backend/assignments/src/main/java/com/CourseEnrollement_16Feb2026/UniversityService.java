package com.prac;
import javax.persistence.*;

public class UniversityService {
	private EntityManager em;
	private InstructorDAO instructorDAO;
	private CourseDAO courseDAO;
    private EnrollmentDAO enrollmentDAO;
    
    UniversityService(EntityManager em){
    	this.em = em;
    	instructorDAO = new InstructorDAO(em);
    	courseDAO = new CourseDAO(em);
        enrollmentDAO = new EnrollmentDAO(em);
    }
    
    public void createInstructorWithProfile() {
    	InstructorProfile profile = new InstructorProfile();
        profile.setOfficeRoom("A101");
        profile.setPhoneNumber("9999999999");
        
        Instructor ins =new Instructor();
        ins.setName("raju");
        ins.setDepartment("CSE");
        ins.setIp(profile);
        
        instructorDAO.saveInstructor(ins);
    }
    
    public void addCourses(Instructor ins) {
    	 Course c1 = new Course();
         c1.setTitle("DSA");
         c1.setCredits(4);

         Course c2 = new Course();
         c2.setTitle("DBMS");
         c2.setCredits(3);
         
         ins.getCourses().add(c1);
         ins.getCourses().add(c2);
         
         instructorDAO.updateInstructor(ins);
    }
    
    public void addEnrollment(Course course) {
    	Enrollment e = new Enrollment();
        e.setSemester("5");
        e.setGrade("A");
        e.setCourse(course);

       enrollmentDAO.saveEnrollment(e);
    }
    
    public void updateEnrollmentGrade(int enrollmentId, String newGrade) {
        enrollmentDAO.updateGrade(enrollmentId, newGrade);
    }
    
    public Instructor fetchInstructorWithCourses(int instructorId) {
        return instructorDAO.findInstructor(instructorId);
    }
    
    public void deleteInstructor(int id) {
        instructorDAO.deleteInstructor(id);
    }


    
}
