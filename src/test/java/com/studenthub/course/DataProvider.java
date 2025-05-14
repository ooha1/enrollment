package com.studenthub.course;

import com.studenthub.course.contracts.StudentContract;

public class DataProvider {
    public static StudentContract getStudentContract() {
        StudentContract studentContract = new StudentContract();
        studentContract.setId(1);
        studentContract.setName("Ooha");
        studentContract.setDateOfBirth("2000-12-01");
        return studentContract;
    }
}
