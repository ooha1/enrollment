package com.studenthub.course.translator;

import com.studenthub.course.contracts.StudentDto;
import com.studenthub.course.entity.Student;
import com.studenthub.course.exception.InvalidDateFormatException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class StudentTranslatorTest {

    @Test
    public void TestToStudent() {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1);
        studentDto.setName("Ooha");
        studentDto.setDateOfBirth("2000-12-01");

        assertEquals(LocalDate.parse("2000-12-01"), StudentTranslator.mapToStudentRequest(studentDto).getDateOfBirth());
    }

    @Test
    public void TestToStudentWithInvalidStudentDateOfBirth() {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1);
        studentDto.setName("Ooha");
        studentDto.setDateOfBirth("2000-19-01");

        assertThrows(InvalidDateFormatException.class, () -> StudentTranslator.mapToStudentRequest(studentDto));
    }

    @Test
    public void TestToStudentContract() {
        Student student = new Student();
        student.setId(1);
        student.setName("Ooha");
        student.setDateOfBirth(LocalDate.parse("2000-12-01"));

        assertEquals("2000-12-01", StudentTranslator.mapToStudentResponse(student).getDateOfBirth());
    }
}
