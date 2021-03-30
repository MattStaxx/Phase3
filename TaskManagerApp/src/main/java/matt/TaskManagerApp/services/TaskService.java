package matt.TaskManagerApp.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import matt.TaskManagerApp.entities.Tasks;
import matt.TaskManagerApp.entities.Users;
import matt.TaskManagerApp.repositories.TaskRepository;


@Service
public class TaskService {

	Logger log = LoggerFactory.getLogger(TaskService.class);
	
	@Autowired
	private TaskRepository taskRepository;

    public Iterable<Tasks> getAllTasks()
	{
        return taskRepository.findAll();
    }

	public Tasks getTaskByName(String taskname) {
		
		return taskRepository.findByName(taskname);
	}
	
	public Iterable<Tasks> getTasksByUserId(Users user) {
		
		return (taskRepository.findAllByUser(user));
	}
	
	@Transactional
	public Tasks save(Tasks task) {
		
		return taskRepository.save(task);
	}
	
	@Transactional
	public void save(Tasks task, String taskName) {

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
	public String deleteByName(String taskname) {
		
		taskRepository.deleteByName(taskname);
		return "Delete sccuessful";
	}
}
