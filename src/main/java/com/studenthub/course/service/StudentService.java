package com.studenthub.course.service;

import com.studenthub.course.contracts.StudentContract;

import java.util.List;

public interface StudentService {

    StudentContract addStudent(StudentContract student);

    List<StudentContract> allStudents();

    List<StudentContract> findStudentsAgeExtremes(String type);


}
