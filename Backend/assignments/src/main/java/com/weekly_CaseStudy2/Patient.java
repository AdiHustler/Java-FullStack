package com.weekly_CaseStudy2;


import javax.persistence.*;

@Entity
public class Patient {

    @Id
    private long id;

    private String name;
    private int age;
    private String contact;

    @OneToOne(cascade = CascadeType.ALL)
    private MedicalRecord medicalRecord;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getContact() { return contact; }
    public void setContact(String contact) { this.contact = contact; }

    public MedicalRecord getMedicalRecord() { return medicalRecord; }
    public void setMedicalRecord(MedicalRecord medicalRecord) {
        this.medicalRecord = medicalRecord;
    }
}
