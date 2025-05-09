package com.studenthub.course.service;

import com.studenthub.course.contracts.StudentContract;
import com.studenthub.course.entity.Student;
import com.studenthub.course.repository.StudentRepository;
import com.studenthub.course.translator.StudentTranslator;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentContract addStudent(StudentContract student) {
        Student studentContract = StudentTranslator.toStudent(student);
        Student saveStudent = studentRepository.save(studentContract);
        return StudentTranslator.toStudentContract(saveStudent);
    }
}
