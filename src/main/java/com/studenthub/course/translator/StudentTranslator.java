package com.studenthub.course.translator;

import com.studenthub.course.contracts.StudentDto;
import com.studenthub.course.entity.Student;
import com.studenthub.course.exception.InvalidDateFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class StudentTranslator {

    public static Student mapToStudentRequest(StudentDto studentDto) {
        Student student = new Student();
        student.setId(studentDto.getId());
        student.setName(studentDto.getName());
        try {
            String dateOfBirth = studentDto.getDateOfBirth();
            student.setDateOfBirth(LocalDate.parse(dateOfBirth));
        } catch (DateTimeParseException ex) {
            throw new InvalidDateFormatException("Invalid date format: " + ex.getMessage());
        }
        return student;
    }

    public static StudentDto mapToStudentResponse(Student student) {
        StudentDto studentDto = new StudentDto();

        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setDateOfBirth(student.getDateOfBirth().toString());
        return studentDto;
    }
}

