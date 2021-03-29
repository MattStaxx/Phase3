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
//@Transactional
public class TaskService {

	Logger log = LoggerFactory.getLogger(TaskService.class);
	
	@Autowired
	private TaskRepository taskRepository;

//	@Autowired
    public Iterable<Tasks> getAllTasks()
		{
	        return taskRepository.findAll();
	    }
//    @Autowired
	public Tasks getTaskbyName(String taskname) {
		
		return taskRepository.findByName(taskname);
	}
	
//	@Autowired
	public Iterable<Tasks> getTasksByUserId(Users user) {
		
		return (taskRepository.findAllByUser(user));
	}
	
//	@Autowired
	public Tasks save(Tasks task) {
		
		return taskRepository.save(task);
	}
}
