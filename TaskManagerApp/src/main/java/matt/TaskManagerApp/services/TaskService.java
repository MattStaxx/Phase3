package matt.TaskManagerApp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import matt.TaskManagerApp.entities.Tasks;
import matt.TaskManagerApp.entities.Users;
import matt.TaskManagerApp.exceptions.TaskNotFoundException;
import matt.TaskManagerApp.repositories.TaskRepository;


@Service
public class TaskService {

	Logger log = LoggerFactory.getLogger(TaskService.class);
	
	@Autowired
	private TaskRepository taskRepository;

    public Iterable<Tasks> findAllTasksByUser(Users user)
	{
        return taskRepository.findAllTasksByUser(user);
    }

	public Tasks getTaskByName(String taskname) {
		
		return taskRepository.findByName(taskname);
	}
	
	@Transactional
	public void save(Tasks task, String taskName) {
		
		if(taskRepository.findByName(taskName) != null) {
			update(task, taskName);
		} else {
			taskRepository.save(task);
		}
	}
	
	@Transactional
	public void update(Tasks task, String taskName) {

		Tasks t = getTaskByName(taskName);
		log.info("updating task with id #..." + t.getId());
		if(taskRepository.existsById(t.getId())) {
			task.setId(t.getId());
			taskRepository.save(task);
		} else {
			taskRepository.save(task);
		}
	}
	
	@Transactional
	public String deleteByName(Users user, String taskname) {

		if(findAllTasksByUser(user) == null) {
			throw new TaskNotFoundException();
		} else taskRepository.deleteByName(taskname);
		return "Delete sccuessful";
	}
}
