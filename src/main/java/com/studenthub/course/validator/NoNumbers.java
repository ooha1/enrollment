package com.studenthub.course.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NoNumbersValidator.class)
public @interface NoNumbers {
    String message() default "Field should not contain numeric characters";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
