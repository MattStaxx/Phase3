package matt.userfeedback.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import matt.userfeedback.exceptions.InvalidInputException;


@ControllerAdvice
public class InvalidInputExceptionController {

	@ExceptionHandler(value = InvalidInputException.class)
	public ResponseEntity<Object> exception(InvalidInputExceptionController exception) {
		
		return new ResponseEntity<>("Invalid Input", HttpStatus.BAD_REQUEST);
	}
}