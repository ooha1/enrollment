package com.studenthub.course.controller;

import com.studenthub.course.contracts.StudentContract;
import com.studenthub.course.service.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class StudentController {
    private final StudentServiceImpl studentServiceImpl;

    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @PostMapping("/addStudent")
    public ResponseEntity<StudentContract> addStudent(@Valid @RequestBody StudentContract student) {
        StudentContract saveStudent = studentServiceImpl.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
    }

    @PutMapping("/allStudents")
    public ResponseEntity<List<StudentContract>> allStudents() {
        List<StudentContract> studentContracts = studentServiceImpl.allStudents();
        return ResponseEntity.status(HttpStatus.OK).body(studentContracts);
    }

    @PutMapping("/extremes/{type}")
    public ResponseEntity<List<StudentContract>> getStudentsAgeExtremes(@PathVariable String type) {
        List<StudentContract> studentContracts = studentServiceImpl.findStudentsAgeExtremes(type);
        return ResponseEntity.status(HttpStatus.OK).body(studentContracts);
    }

}
