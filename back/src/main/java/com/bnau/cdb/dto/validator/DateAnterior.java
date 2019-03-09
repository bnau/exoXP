package com.bnau.cdb.dto.validator;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = DateAnteriorValidator.class)
@Target({ ElementType.TYPE })
@Retention(RUNTIME)
public @interface DateAnterior {

	String message() default "The dates must be reversed.";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
}
