package com.studenthub.course.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NoNumbersValidator implements ConstraintValidator<NoNumbers, String> {
    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return (name == null) || !name.matches(".*\\d.*");
    }
}
