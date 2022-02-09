package com.slr3073.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithValidator implements ConstraintValidator<StartWith, String> {

    private String prefix;

    @Override
    public void initialize(StartWith startWith) {
        prefix = startWith.value();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext context) {
        if(s == null || s.isEmpty()) return true;

        return s.startsWith(prefix);
    }
}
