package com.weekly_CaseStudy2;

import javax.persistence.*;

@Entity
public class Appointment {

    @Id
    private long id;

    private String visitDate;
    private double fee;

    @ManyToOne
    private Patient patient;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getVisitDate() { return visitDate; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }

    public Patient getPatient() { return patient; }
    public void setPatient(Patient patient) { this.patient = patient; }
}
