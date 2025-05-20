package com.studenthub.course.repository;

import com.studenthub.course.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<Student, Long>, JpaRepository<Student, Long> {

    @Query(value = """
            SELECT * FROM studentmanagementcourse.student WHERE date_of_birth IN ((SELECT MIN(date_of_birth) FROM studentmanagementcourse.student))
            """, nativeQuery = true)
    List<Student> findOldestStudents();

    @Query(value = """
            SELECT * FROM studentmanagementcourse.student WHERE date_of_birth IN ((SELECT MAX(date_of_birth) FROM studentmanagementcourse.student))
            """, nativeQuery = true)
    List<Student> findYoungestStudents();

    @Query(value = """
            SELECT * FROM studentmanagementcourse.student WHERE date_of_birth IN ((SELECT MAX(date_of_birth) FROM studentmanagementcourse.student),
                (SELECT MIN(date_of_birth) FROM studentmanagementcourse.student))
            """, nativeQuery = true)
    List<Student> findOldestAndYoungestStudents();
}
