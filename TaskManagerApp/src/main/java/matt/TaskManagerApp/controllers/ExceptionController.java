package matt.TaskManagerApp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import matt.TaskManagerApp.exceptions.TaskNotFoundException;
import matt.TaskManagerApp.exceptions.UserNameAlreadyExistsException;
import matt.TaskManagerApp.exceptions.UserNotFoundException;

@ControllerAdvice
public class ExceptionController {

	Logger log = LoggerFactory.getLogger(LoginController.class);

	@ExceptionHandler(value=UserNotFoundException.class)
	public String unfException(UserNotFoundException unf) {

    	log.info("Redirecting to error view...");
		return "usernotfound";
	}
	
	@ExceptionHandler(value=UserNameAlreadyExistsException.class)
	public String unaException() {

    	log.info("Redirecting to error view...");
		return "useralreadyexists";
	}

	@ExceptionHandler(value=TaskNotFoundException.class)
	public String tnfException() {

    	log.info("Redirecting to error view...");
		return "tasknotfound";
	}
}
