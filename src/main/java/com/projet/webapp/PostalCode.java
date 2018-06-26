package com.projet.webapp;

import java.lang.annotation.*;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = PostalCodeValidator.class)
@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PostalCode {
	String message() default "{validator.postalcode}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
