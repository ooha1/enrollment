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

    @PostMapping("/students")
    public ResponseEntity<StudentContract> addStudent(@Valid @RequestBody StudentContract student) {
        StudentContract saveStudent = studentServiceImpl.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentContract>> allStudents(@RequestParam int page, @RequestParam int size) {
        List<StudentContract> studentContracts = studentServiceImpl.allStudents(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(studentContracts);
    }

    @GetMapping("/extremes")
    public ResponseEntity<List<StudentContract>> getStudentsAgeExtremes(@RequestParam(required = false) String type) {
        List<StudentContract> studentContracts = studentServiceImpl.findStudentsAgeExtremes(type);
        return ResponseEntity.status(HttpStatus.OK).body(studentContracts);
    }

}
