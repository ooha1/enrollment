package com.studenthub.course;

import com.studenthub.course.contracts.StudentDto;

public class DataProvider {
    public static StudentDto getStudentContract() {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1);
        studentDto.setName("Ooha");
        studentDto.setDateOfBirth("2000-12-01");
        return studentDto;
    }
}
