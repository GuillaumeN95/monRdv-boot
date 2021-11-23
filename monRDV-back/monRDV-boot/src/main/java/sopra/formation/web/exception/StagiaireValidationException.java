package sopra.formation.web.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Le stagiaire n'a pu être validée")
public class StagiaireValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
