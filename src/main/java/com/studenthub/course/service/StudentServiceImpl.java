package com.studenthub.course.service;

import com.studenthub.course.constants.Type;
import com.studenthub.course.contracts.StudentDto;
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
    public StudentDto addStudent(StudentDto studentDto) {
        Student student = StudentTranslator.mapToStudentRequest(studentDto);
        Student saveStudent = studentRepository.save(student);
        return StudentTranslator.mapToStudentResponse(saveStudent);
    }


    @Override
    public List<StudentDto> allStudents(int page, int size) {
        Iterable<Student> students = studentRepository.findAll(PageRequest.of(page, size));
        List<StudentDto> contracts = new ArrayList<StudentDto>();
        for (Student student : students) {
            contracts.add(StudentTranslator.mapToStudentResponse(student));
        }
        return contracts;
    }

    @Override
    public List<StudentDto> findStudentsAgeExtremes(String type) {
        List<StudentDto> contracts = new ArrayList<StudentDto>();

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


    @Override
    public StudentDto findStudentById(StudentDto studentDto) {
        Student student = StudentTranslator.mapToStudentRequest(studentDto);

        Student existingStudent = studentRepository.findById(student.getId()).get();
        existingStudent.setId(student.getId());
        existingStudent.setName(student.getName());
        existingStudent.setDateOfBirth(student.getDateOfBirth());

        Student updatedStudent = studentRepository.save(existingStudent);
        return StudentTranslator.mapToStudentResponse(updatedStudent);
    }

    @Override
    public boolean deleteStudentById(Long id) {
        if (studentRepository.existsById(id)) {
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
