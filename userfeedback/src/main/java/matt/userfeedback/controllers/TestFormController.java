package matt.userfeedback.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import matt.userfeedback.entities.Feedback;
import matt.userfeedback.services.FeedbackService;


@Controller
public class TestFormController {

	@Autowired
	FeedbackService feedbackService;
	FeedbackController fbc = new FeedbackController();
	Logger logger = LoggerFactory.getLogger(TestFormController.class);
	
	@GetMapping(value="/testform")
    public String showIndexPage(ModelMap model) {
		
		logger.info("Starting jsp test...");
		return "testformjsp";
	} 
//
//	@PostMapping(value="/newFeedback")  // , consumes=MediaType.APPLICATION_JSON_VALUE
//	public Feedback addFeedback(@RequestParam(value="comments") String comments, @RequestParam(value="rating") int rating, 
//								@RequestParam(value="user") String user) {
//		
//		Feedback fb = new Feedback();
//		fb.setComments(comments);
//		fb.setRating(rating);
//		fb.setUser(user);
//
//		logger.info("Setting feedback data...");
//		fbc.getAllFeedback();
//		return feedbackService.save(fb);
//	}
}
