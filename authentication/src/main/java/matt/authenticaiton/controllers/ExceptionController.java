package matt.authenticaiton.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import matt.authenticaiton.exceptions.UserNotFoundException;

@ControllerAdvice
public class ExceptionController {

	Logger log = LoggerFactory.getLogger(LoginController.class);

	@ExceptionHandler(value=UserNotFoundException.class)
	public String exception(UserNotFoundException unf) {

    	log.info("Redirecting to error view...");
		return "usernotfound";
	}
}
