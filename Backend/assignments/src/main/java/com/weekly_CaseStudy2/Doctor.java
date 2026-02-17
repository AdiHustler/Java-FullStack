package com.weekly_CaseStudy2;

import java.util.*;
import javax.persistence.*;

@Entity
public class Doctor {

    @Id
    private long id;

    private String name;
    private String specialization;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Appointment> appointments = new ArrayList<>();

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialization() { return specialization; }
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public List<Appointment> getAppointments() { return appointments; }
    public void setAppointments(List<Appointment> appointments) {
        this.appointments = appointments;
    }
}
