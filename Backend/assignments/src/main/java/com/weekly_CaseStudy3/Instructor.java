package com.weekly_CaseStudy3;
 	 	 	
import java.util.*;
import javax.persistence.*;

@Entity
public class Instructor {

    @Id
    private long id;

    private String name;
    private String department;

    @OneToOne(cascade = CascadeType.ALL)
    private InstructorProfile profile;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Course> courses = new ArrayList<>();

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) {
        this.department = department;
    }

    public InstructorProfile getProfile() { return profile; }
    public void setProfile(InstructorProfile profile) {
        this.profile = profile;
    }

    public List<Course> getCourses() { return courses; }
}
