package com.bnau.cdb.dto.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.bnau.cdb.dto.ComputerDto;

public class DateAnteriorValidator implements ConstraintValidator<DateAnterior, ComputerDto> {

	@Override
	public void initialize(final DateAnterior constraintAnnotation) {
		
	}

	@Override
	public boolean isValid(final ComputerDto computer, final ConstraintValidatorContext context) {
		return !(computer.getIntroduced() != null && computer.getDiscontinued() != null
				&& computer.getIntroduced().isAfter(computer.getDiscontinued()));
	}
	
}
