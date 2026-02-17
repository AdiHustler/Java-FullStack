package com.weekly_CaseStudy3;

import java.util.List;

public class UniversityService {

    private InstructorDAO instructorDAO = new InstructorDAO();
    private CourseDAO courseDAO = new CourseDAO();
    private EnrollmentDAO enrollmentDAO = new EnrollmentDAO();

    public void createInstructor(Instructor i) {
        instructorDAO.saveInstructor(i);
    }

    public void addCourses(long instructorId, List<Course> courses) {

        Instructor i = instructorDAO.findInstructor(instructorId);
        i.getCourses().addAll(courses);

        instructorDAO.updateInstructor(i);
    }

    public void addEnrollment(Enrollment e) {
        enrollmentDAO.saveEnrollment(e);
    }

    public void updateGrade(long id, String grade) {
        enrollmentDAO.updateGrade(id, grade);
    }
    public Instructor getInstructor(long id) {
        return instructorDAO.findInstructor(id);
    }

    public void deleteInstructor(long id) {
        instructorDAO.deleteInstructor(id);
    }
}
