package com.studenthub.course.controller;

import com.studenthub.course.entity.Student;
import com.studenthub.course.service.StudentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/create")
    private Student create(@Valid @RequestBody Student student) {
        return studentService.saveStudent(student);
    }

}
