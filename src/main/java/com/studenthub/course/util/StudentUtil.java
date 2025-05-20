package com.studenthub.course.util;

import com.studenthub.course.contracts.StudentContract;
import com.studenthub.course.entity.Student;
import com.studenthub.course.translator.StudentTranslator;

import java.util.List;

public class StudentUtil {
    public static void listOfStudentsUtil(List<Student> youngestStudent, List<StudentContract> contracts) {
        for (Student student : youngestStudent) {
            contracts.add(StudentTranslator.toStudentContract(student));
        }
    }
}
