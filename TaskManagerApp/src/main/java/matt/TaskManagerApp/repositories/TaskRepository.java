package matt.TaskManagerApp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import matt.TaskManagerApp.entities.Tasks;
import matt.TaskManagerApp.entities.Users;

@Repository
public interface TaskRepository extends CrudRepository<Tasks, Integer> {

	public Tasks findByName(String name);
	public Iterable<Tasks> findAllByUser(Users user);
	public Tasks save(String name);
	public Integer deleteByName(String name);
}

