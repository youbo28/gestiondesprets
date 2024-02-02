package com.ayoub.gestiondespret.validators;

import com.ayoub.gestiondespret.costumAnnotations.ValidateNomDEmploye;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
/*
 * cette classe s'assure que le nom de l'employé ne peut pas contenir de chiffres
 * */
public class EmployeNomValidator implements ConstraintValidator<ValidateNomDEmploye, String> {

	@Override
	public boolean isValid(String nomCompletEmploye, ConstraintValidatorContext context) {
		
		return nomCompletEmploye != null && nomCompletEmploye.matches("^[a-zA-Z ]*$");
	}

}
