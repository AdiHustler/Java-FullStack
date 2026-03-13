package com.assignment.student_management_system.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String course;
    private Double marks;

    @Lob
    private byte[] profileImage;

    @Lob
    private byte[] assignmentFile;
}
