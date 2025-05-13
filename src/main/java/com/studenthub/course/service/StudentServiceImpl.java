package com.studenthub.course.service;

import com.studenthub.course.contracts.StudentContract;
import com.studenthub.course.entity.Student;
import com.studenthub.course.repository.StudentRepository;
import com.studenthub.course.translator.StudentTranslator;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

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


    @Override
    public List<StudentContract> allStudents() {
        Iterable<Student> students = studentRepository.findAll();
        List<StudentContract> contracts = new ArrayList<StudentContract>();
        for (Student student : students) {
            contracts.add(StudentTranslator.toStudentContract(student));
        }

        return contracts;
    }

    @Override
    public List<StudentContract> findStudentsAgeExtremes(String type) {
        StudentContract selectedStudent = null;

        Iterable<Student> students = studentRepository.findAll();
        List<StudentContract> contracts = new ArrayList<>();
        for (Student student : students) {
            contracts.add(StudentTranslator.toStudentContract(student));
        }

        for (StudentContract studentContract : contracts) {
            int selectedAge = 0;

            if (null != studentContract.getDateOfBirth()) {
                LocalDate dateOfBirth = LocalDate.parse(studentContract.getDateOfBirth());
                int age = Period.between(dateOfBirth, LocalDate.now()).getYears();

                switch (type.toLowerCase()) {
                    case "youngest":
                        if (age > selectedAge) {
                            selectedAge = age;
                            selectedStudent = studentContract;
                        }
                        break;

                    case "oldest":
                        if (age < selectedAge) {
                            selectedAge = age;
                            selectedStudent = studentContract;
                        }
                        break;
                }
            }
        }

        return selectedStudent != null ? List.of(selectedStudent) : List.of();
    }
}
