package monRdv.web.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sopra.monRdv.model.Praticien;

public class EvaluationValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Praticien.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Praticien praticien = (Praticien) target;

		if (praticien.getSpecialites() == null) {
			errors.rejectValue("commentaires", "evaluation.commentaires.error.notnull", "Veuillez renseigner la spécialité !");
		}
	}

}
