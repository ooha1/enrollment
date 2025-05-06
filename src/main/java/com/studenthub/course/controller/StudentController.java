package com.studenthub.course.controller;

import com.studenthub.course.entity.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class StudentController {

    @PostMapping("/create")
    private ResponseEntity<Student> create(@RequestBody Student student) {
        return ResponseEntity.ok().body(student);
    }

}
