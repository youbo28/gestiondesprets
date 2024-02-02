package com.ayoub.gestiondespret.costumAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.validation.Payload;

import com.ayoub.gestiondespret.validators.EmployeNomValidator;

import jakarta.validation.Constraint;
import java.lang.annotation.Target;

@Constraint(validatedBy = EmployeNomValidator.class)
@Target({ ElementType.FIELD, ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)

public @interface ValidateNomDEmploye {

	String message() default "the name of employe can't be null or contain any numbers";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
