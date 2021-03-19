package matt.userfeedback.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matt.userfeedback.entities.Feedback;
import matt.userfeedback.repositories.FeedbackRepository;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepository feedbackRepository;
	
	public Iterable<Feedback> getAllFeedback() {

		return feedbackRepository.findAll();
	}

	public Feedback save(Feedback feed) {

		Feedback newFeedback = feedbackRepository.save(feed);
		
		return newFeedback;
	}
}
