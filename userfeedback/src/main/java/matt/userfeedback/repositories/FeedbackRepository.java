package matt.userfeedback.repositories;

import org.springframework.data.repository.CrudRepository;

import matt.userfeedback.entities.Feedback;


public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {

	public Feedback save(String sql); // 

}
