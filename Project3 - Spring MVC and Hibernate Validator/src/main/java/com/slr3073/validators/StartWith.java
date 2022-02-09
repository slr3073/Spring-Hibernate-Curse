package com.slr3073.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = StartWithValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface StartWith {
    public String value() default "SLR";
    public String message() default "Doit commencer par SLR";

    public Class<?>[] groups() default {};
    public  Class<? extends Payload>[] payload() default {};
}
