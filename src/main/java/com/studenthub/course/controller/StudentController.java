package com.studenthub.course.controller;

import com.studenthub.course.contracts.StudentDto;
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

    @PostMapping("/student")
    public ResponseEntity<StudentDto> addStudent(@Valid @RequestBody StudentDto student) {
        StudentDto saveStudent = studentServiceImpl.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveStudent);
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentDto>> allStudents(@RequestParam int page, @RequestParam int size) {
        List<StudentDto> studentDtoList = studentServiceImpl.allStudents(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(studentDtoList);
    }

    @GetMapping("/extremes")
    public ResponseEntity<List<StudentDto>> getStudentsAgeExtremes(@RequestParam(required = false) String type) {
        List<StudentDto> studentDtoList = studentServiceImpl.findStudentsAgeExtremes(type);
        return ResponseEntity.status(HttpStatus.OK).body(studentDtoList);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<StudentDto> getStudentById(@Valid @RequestBody StudentDto student, @PathVariable("id") Long studentId) {
        StudentDto studentById = studentServiceImpl.findStudentById(student);
        return ResponseEntity.status(HttpStatus.OK).body(studentById);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable("id") Long studentId) {
        boolean deleteStudentById = studentServiceImpl.deleteStudentById(studentId);
        if(deleteStudentById){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
