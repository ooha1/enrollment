package com.studenthub.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/home")
    private String home() {
        return "Welcome to Student Management Course Home Page";
    }
}
