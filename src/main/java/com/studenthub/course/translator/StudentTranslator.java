package com.studenthub.course.translator;

import com.studenthub.course.contracts.StudentContract;
import com.studenthub.course.entity.Student;
import com.studenthub.course.exception.InvalidDateFormatException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

@Component
public class StudentTranslator {

    public static Student toStudent(StudentContract contract) {
        Student student = new Student();
        student.setId(contract.getId());
        student.setName(contract.getName());
        try {
            String dateOfBirth = contract.getDateOfBirth();
            student.setDateOfBirth(LocalDate.parse(dateOfBirth));
        } catch (DateTimeParseException ex) {
            throw new InvalidDateFormatException("Invalid date format: " + ex.getMessage());
        }
        return student;
    }

    public static StudentContract toStudentContract(Student student) {

        StudentContract contract = new StudentContract();
        contract.setId(student.getId());
        contract.setName(student.getName());

        LocalDate dateOfBirth = student.getDateOfBirth();
        contract.setDateOfBirth(dateOfBirth.toString());

        return contract;
    }
}

