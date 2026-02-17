package com.weekly_CaseStudy2;


import javax.persistence.*;

@Entity
public class MedicalRecord {

    @Id
    private long id;

    private String bloodGroup;
    private String allergies;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getBloodGroup() { return bloodGroup; }
    public void setBloodGroup(String bloodGroup) { this.bloodGroup = bloodGroup; }

    public String getAllergies() { return allergies; }
    public void setAllergies(String allergies) { this.allergies = allergies; }
}
