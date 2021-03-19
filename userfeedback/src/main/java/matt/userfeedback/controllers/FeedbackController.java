package matt.userfeedback.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import matt.userfeedback.entities.Feedback;
import matt.userfeedback.services.FeedbackService;

@RestController
public class FeedbackController {

	@Autowired
	FeedbackService feedbackService;
	
	Logger logger = LoggerFactory.getLogger(FeedbackController.class);

//  curl -X GET http://localhost:8090/feedback
	@GetMapping("/feedback")
	public Iterable<Feedback> getAllFeedback() { 

		logger.info("Getting feedback data...");
        return feedbackService.getAllFeedback();
    }

	// curl -X POST localhost:8090/newFeedback -H "Content-type:application/json" -d "{\"comments\":\"Awesome\",\"rating\":10,\"user\":\"Tim\"}" 
	@PostMapping(value="/newFeedback", consumes="application/json")
	public Feedback postFeedback(@RequestBody Feedback feedback) {

		logger.info("Setting feedback data json...");
		return feedbackService.save(feedback);
	}
	
	@PostMapping(value="/newFeedback")
	public Feedback addFeedback(@RequestParam(value="comments") String comments, @RequestParam(value="rating") int rating, 
								@RequestParam(value="user") String user) {
		
		Feedback fb = new Feedback();
		fb.setComments(comments);
		fb.setRating(rating);
		fb.setUser(user);

		logger.info("Setting feedback data text...");
		return feedbackService.save(fb);
	}
	
}