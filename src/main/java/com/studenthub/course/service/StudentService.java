package com.studenthub.course.service;

import com.studenthub.course.contracts.StudentDto;

import java.util.List;

public interface StudentService {

    StudentDto addStudent(StudentDto student);

    List<StudentDto> allStudents(int page, int size);

    List<StudentDto> findStudentsAgeExtremes(String type);

    StudentDto findStudentById(StudentDto studentDto);

    boolean deleteStudentById(Long id);

}
