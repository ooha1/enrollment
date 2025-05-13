package com.studenthub.course.translator;

import com.studenthub.course.contracts.StudentContract;
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
        StudentContract studentContract = new StudentContract();
        studentContract.setId(1);
        studentContract.setName("Ooha");
        studentContract.setDateOfBirth("2000-12-01");

        assertEquals(LocalDate.parse("2000-12-01"), StudentTranslator.toStudent(studentContract).getDateOfBirth());
    }

    @Test
    public void TestToStudentWithInvalidStudentDateOfBirth() {
        StudentContract studentContract = new StudentContract();
        studentContract.setId(1);
        studentContract.setName("Ooha");
        studentContract.setDateOfBirth("2000-19-01");

        assertThrows(InvalidDateFormatException.class, () -> StudentTranslator.toStudent(studentContract));
    }

    @Test
    public void TestToStudentContract() {
        Student student = new Student();
        student.setId(1);
        student.setName("Ooha");
        student.setDateOfBirth(LocalDate.parse("2000-12-01"));

        assertEquals("2000-12-01", StudentTranslator.toStudentContract(student).getDateOfBirth());
    }
}
