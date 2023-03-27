package com.ivankrn.springbootcourse.model;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.constraints.Max;
import java.lang.annotation.*;


@Constraint(validatedBy = BugSeverityValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Max(10) // второй пункт ДЗ, аннотация объединяющая другую аннотацию
public @interface SeverityConstraint {
    String message() default "Bug severity must be a non-negative value!";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
