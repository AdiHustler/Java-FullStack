package com.weekly_CaseStudy3;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    private long id;

    private String title;
    private int credits;

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getCredits() { return credits; }
    public void setCredits(int credits) { this.credits = credits; }
}
