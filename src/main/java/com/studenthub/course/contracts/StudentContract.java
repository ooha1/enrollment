package com.studenthub.course.contracts;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StudentContract {
    private long id;

    @Pattern(regexp = "^\\D*$", message = "Field should not contain numeric characters")
    private String name;

    @NotNull(message = "Date Of Birth Must Not Be Null")
    private String dateOfBirth;

}
