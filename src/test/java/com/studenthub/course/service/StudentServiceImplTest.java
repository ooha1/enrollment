package com.studenthub.course.service;

import com.studenthub.course.contracts.StudentContract;
import com.studenthub.course.entity.Student;
import com.studenthub.course.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static com.studenthub.course.DataProvider.getStudentContract;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentServiceImpl studentService;

    StudentContract studentContract;

    @BeforeEach
    void setUp() {
        studentContract = getStudentContract();
    }

    @Test
    public void addStudentSuccessfully() {

        Student student = new Student();
        student.setId(1);
        student.setName("Ooha");
        student.setDateOfBirth(LocalDate.parse("2000-12-01"));

        Mockito.when(studentRepository.save(Mockito.any(Student.class))).thenReturn(student);

        StudentContract addedStudent = studentService.addStudent(studentContract);

        assertEquals(studentContract.getName(), addedStudent.getName());
    }


}
