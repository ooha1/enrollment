package com.studenthub.course.service;

import com.studenthub.course.constants.Type;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void getStudentsSuccessfully() {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "ooha", LocalDate.parse("2000-12-01")));
        students.add(new Student(1, "chiki", LocalDate.parse("2002-02-02")));

        Page<Student> studentPage = new PageImpl<>(students);

        Mockito.when(studentRepository.findAll(PageRequest.of(1, 1))).thenReturn(studentPage);

        List<StudentContract> studentContracts = studentService.allStudents(1, 1);

        assertEquals(2, studentContracts.size());
        assertEquals("ooha", studentContracts.get(0).getName());
    }

    @Test
    public void getStudentsOldestStudentSuccessfully() {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "ooha", LocalDate.parse("2000-12-01")));
        students.add(new Student(1, "chiki", LocalDate.parse("2002-02-02")));


        Mockito.when(studentRepository.findOldestStudents()).thenReturn(students);

        List<StudentContract> studentContracts = studentService.findStudentsAgeExtremes(Type.OLDEST.name());

        assertEquals("chiki", studentContracts.get(1).getName());
    }


}
