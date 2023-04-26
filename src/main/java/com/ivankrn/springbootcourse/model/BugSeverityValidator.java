package com.ivankrn.springbootcourse.model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class BugSeverityValidator implements ConstraintValidator<SeverityConstraint, Integer> {
    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value >= 0;
    }
}
