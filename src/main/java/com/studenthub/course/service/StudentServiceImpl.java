package com.studenthub.course.service;

import com.studenthub.course.constants.Type;
import com.studenthub.course.contracts.StudentContract;
import com.studenthub.course.entity.Student;
import com.studenthub.course.repository.StudentRepository;
import com.studenthub.course.translator.StudentTranslator;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.studenthub.course.util.StudentUtil.listOfStudentsUtil;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public StudentContract addStudent(StudentContract studentContract) {
        Student student = StudentTranslator.toStudent(studentContract);
        Student saveStudent = studentRepository.save(student);
        return StudentTranslator.toStudentContract(saveStudent);
    }


    @Override
    public List<StudentContract> allStudents(int page, int size) {
        Iterable<Student> students = studentRepository.findAll(PageRequest.of(page, size));
        List<StudentContract> contracts = new ArrayList<StudentContract>();
        for (Student student : students) {
            contracts.add(StudentTranslator.toStudentContract(student));
        }
        return contracts;
    }

    @Override
    public List<StudentContract> findStudentsAgeExtremes(String type) {
        List<StudentContract> contracts = new ArrayList<StudentContract>();

        if (type.equalsIgnoreCase(Type.YOUNGEST.name())) {
            List<Student> youngestStudent = studentRepository.findYoungestStudents();
            listOfStudentsUtil(youngestStudent, contracts);
            return contracts;
        } else if (type.equalsIgnoreCase(Type.OLDEST.name())) {
            List<Student> oldestStudent = studentRepository.findOldestStudents();
            listOfStudentsUtil(oldestStudent, contracts);
            return contracts;
        } else {
            List<Student> youngestStudent = studentRepository.findOldestAndYoungestStudents();
            listOfStudentsUtil(youngestStudent, contracts);
            return contracts;
        }
    }

}
