package matt.userfeedback.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import matt.userfeedback.entities.Feedback;
import matt.userfeedback.exceptions.InvalidInputException;
import matt.userfeedback.services.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
	
	Logger logger = LoggerFactory.getLogger(FeedbackController.class);

	@GetMapping("/feedback")
	public Iterable<Feedback> getAllFeedback() { 

		logger.info("Getting feedback data...");
        return feedbackService.getAllFeedback();
    }

	@PostMapping(value="/newFeedback", consumes="application/json")
	public Feedback postFeedback(@RequestBody Feedback feedback) {

		logger.info("Setting feedback data JSON...");
		return feedbackService.save(feedback);
	}
	
	@PostMapping(value="/newFeedback")
	public Feedback addFeedback(@RequestParam(value="comments") String comments, @RequestParam(value="rating") int rating, 
								@RequestParam(value="user") String user) {
		
		Feedback fb = new Feedback();

		if(comments.isBlank() || user.isBlank() || rating < 1 || rating > 5) {
			logger.info("Data Input Error...");
			throw new InvalidInputException();
		} else {
			fb.setComments(comments);
			fb.setRating(rating);
			fb.setUser(user);
		}
		logger.info("Setting feedback data HTML...");
		return feedbackService.save(fb);
	}
	
}