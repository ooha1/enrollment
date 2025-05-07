package com.studenthub.course.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.studenthub.course.validator.NoNumbers;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NoNumbers
    private String name;

    @NotNull(message = "Date Of Birth Must Not Be Null")
    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private LocalDate dateOfBirth;
}
