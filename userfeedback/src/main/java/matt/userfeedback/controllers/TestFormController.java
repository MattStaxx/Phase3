package matt.userfeedback.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class TestFormController {
	
Logger logger = LoggerFactory.getLogger(TestFormController.class);
	
	@GetMapping(value = "/testform")
    public String showIndexPage(ModelMap model) {
		
		//TODO: Create a jsp called "testform.jsp"
		logger.info("Starting jsp test...");
		return "testformjsp";
	} 

	//@PostMapping("/test")
	//TODO: form submission
	//TODO: add view jsp
	//TODO: clal RestTemplate and make POST JSON request to localhost:8090/userfeedback
}
