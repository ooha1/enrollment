package com.studenthub.course.service;

import com.studenthub.course.contracts.StudentContract;

import java.util.List;

public interface StudentService {

    StudentContract addStudent(StudentContract student);

    List<StudentContract> allStudents(int page, int size);

    List<StudentContract> findStudentsAgeExtremes(String type);


}
