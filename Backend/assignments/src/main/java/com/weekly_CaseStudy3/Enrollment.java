package com.weekly_CaseStudy3;

import javax.persistence.*;

@Entity
public class Enrollment {

    @Id
    private long id;

    private String semester;
    private String grade;

    @ManyToOne
    private Course course;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getSemester() { return semester; }
    public void setSemester(String semester) { this.semester = semester; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }

    public Course getCourse() { return course; }
    public void setCourse(Course course) { this.course = course; }
}
