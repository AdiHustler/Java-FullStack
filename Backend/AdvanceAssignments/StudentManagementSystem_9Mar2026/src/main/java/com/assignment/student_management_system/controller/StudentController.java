package com.assignment.student_management_system.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.assignment.student_management_system.entity.Student;
import com.assignment.student_management_system.service.StudentService;

@RestController
@RequestMapping("/api/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public Page<Student> getAllStudents(Pageable pageable) {
        return studentService.getAllStudents(pageable);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student studentDetails) {
        return studentService.updateStudent(id, studentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PostMapping("/{id}/profile-image")
    public Student uploadProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file)
            throws Exception {
        return studentService.uploadProfileImage(id, file.getBytes());
    }

    @PostMapping("/{id}/assignment-file")
    public Student uploadAssignmentFile(@PathVariable Long id, @RequestParam("file") MultipartFile file)
            throws Exception {
        return studentService.uploadAssignmentFile(id, file.getBytes());
    }

    @GetMapping("/{id}/profile-image")
    public ResponseEntity<byte[]> downloadProfileImage(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"profile.jpg\"")
                .contentType(MediaType.IMAGE_JPEG)
                .body(student.getProfileImage());
    }

    @GetMapping("/{id}/assignment-file")
    public ResponseEntity<byte[]> downloadAssignmentFile(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"assignment.pdf\"")
                .contentType(MediaType.APPLICATION_PDF)
                .body(student.getAssignmentFile());
    }
}
