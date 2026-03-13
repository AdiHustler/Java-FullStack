package com.assignment.student_management_system.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.assignment.student_management_system.entity.Student;
import com.assignment.student_management_system.repository.StudentRepository;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @PreAuthorize("hasRole('ADMIN')")
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Cacheable(value = "students", key = "#id")
    @PostAuthorize("hasRole('ADMIN') or returnObject.email == authentication.name")
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Page<Student> getAllStudents(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Student updateStudent(Long id, Student studentDetails) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        student.setCourse(studentDetails.getCourse());
        student.setMarks(studentDetails.getMarks());
        if (studentDetails.getProfileImage() != null) {
            student.setProfileImage(studentDetails.getProfileImage());
        }
        if (studentDetails.getAssignmentFile() != null) {
            student.setAssignmentFile(studentDetails.getAssignmentFile());
        }
        return studentRepository.save(student);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Student uploadProfileImage(Long id, byte[] imageData) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setProfileImage(imageData);
        return studentRepository.save(student);
    }

    @PreAuthorize("hasRole('ADMIN')")
    public Student uploadAssignmentFile(Long id, byte[] fileData) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
        student.setAssignmentFile(fileData);
        return studentRepository.save(student);
    }
}
