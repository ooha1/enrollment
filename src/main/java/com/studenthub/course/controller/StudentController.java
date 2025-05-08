package com.studenthub.course.controller;

import com.studenthub.course.entity.Student;
import com.studenthub.course.service.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;

    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {
        Student saveStudent = studentServiceImpl.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
    }

}
