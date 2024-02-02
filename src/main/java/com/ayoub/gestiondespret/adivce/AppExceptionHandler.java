package com.ayoub.gestiondespret.adivce;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

/*
 * cette classe est chargée de gérer les erreurs qui peuvent survenir lors   de l'exécution et 
 * de les afficher sous forme de réponse json avec le statut http.*/

@RestControllerAdvice
@RequestMapping("/api/advice")
public class AppExceptionHandler {

	/* une méthode qui gère les erreurs de validation */
	@GetMapping
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleInvalidArgument(
			MethodArgumentNotValidException methodArgumentNotValidException) {
		Map<String, String> errorsMap = new HashMap<>();
		methodArgumentNotValidException.getBindingResult().getFieldErrors()
				.forEach(error -> errorsMap.put(error.getField(), error.getDefaultMessage()));

		return new ResponseEntity<Map<String, String>>(errorsMap, HttpStatus.BAD_REQUEST);
	}

	/*
	 * une méthode qui gère les erreurs lors de la tentative de préforme sur un
	 * objet qui n'existe pas
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleNotFoundOrOutOfRangeEntity(
			EntityNotFoundException entityNotFoundException) {
		Map<String, String> errorsMessage = new HashMap<>();
		errorsMessage.put("error", entityNotFoundException.getMessage());

		return new ResponseEntity<Map<String, String>>(errorsMessage, HttpStatus.BAD_REQUEST);
	}

	/*
	 * this method hundle all type of exception and show it as internal server error
	 */
	@GetMapping
	@ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, String>> handleGenericException(EntityNotFoundException entityNotFoundException) {
		Map<String, String> errorsMessage = new HashMap<>();
		errorsMessage.put("error", entityNotFoundException.getMessage());
		return new ResponseEntity<Map<String, String>>(errorsMessage, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
