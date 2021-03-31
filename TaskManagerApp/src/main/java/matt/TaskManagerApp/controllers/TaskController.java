package matt.TaskManagerApp.controllers;


import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import matt.TaskManagerApp.entities.Tasks;
import matt.TaskManagerApp.entities.Users;
import matt.TaskManagerApp.services.TaskService;
import matt.TaskManagerApp.services.UserService;

@Controller
public class TaskController {

	@Autowired
	TaskService tServ;

	@Autowired
	UserService uServ;
	
	Logger log = LoggerFactory.getLogger(LoginController.class);
    
	@PostMapping(value="/home")
	public String listAllTasks(ModelMap m, @RequestParam String act, @RequestParam String userName) {
		
		if(act.equals("view")) {
        	Users user = uServ.getUserByName(userName);
			log.info("in home passing to tasklist..." + userName);
	    	Iterable<Tasks> allTasks = tServ.findAllTasksByUser(user);
	    	if(allTasks == null) {
	    		m.addAttribute("e", allTasks);
	    	}
	    	m.addAttribute("userName", userName);
	    	m.addAttribute("list", allTasks);
	    	return "tasklist";
		}
		if(act.equals("manage")) {
			log.info("in home passing to taskform..." + userName);
			m.addAttribute("userName", userName);
			return "taskform";
		}
		return "home";
	}
	
	@GetMapping(value="/home")
	public String findHome(ModelMap m, @RequestParam String userName) {
		
		log.info("in findHome passing to home..." + userName);
		m.addAttribute("userName", userName);
		return "home";
	}
	
    @PostMapping(value="/manage")
    public String addTask(ModelMap m, @RequestParam String name, @RequestParam Date start, @RequestParam Date end,
    								  @RequestParam String desc, @RequestParam String sev, @RequestParam String act, @RequestParam String userName) {

    	if(act.equals("create")) {

        	log.info("start add tasks..." + userName);
        	Users user = uServ.getUserByName(userName);
        	Tasks task = new Tasks();
        	task.setName(name);
        	task.setStart(start);
        	task.setEnd(end);
        	task.setDesc(desc);
        	task.setSeverity(sev);
        	task.setUser(user);
        	m.addAttribute("task", task);
        	m.addAttribute("userName", userName);
        	tServ.save(task, name);
    	}
    	
    	if(act.equals("update")) {

        	log.info("start update tasks..." + userName);
        	Users user = uServ.getUserByName(userName);
        	Tasks task = new Tasks();
        	task.setName(name);
        	task.setStart(start);
        	task.setEnd(end);
        	task.setDesc(desc);
        	task.setSeverity(sev);
        	task.setUser(user);
        	m.addAttribute("task", task);
        	m.addAttribute("userName", userName);
        	tServ.update(task, name);
    	}
    	
    	if(act.equals("delete")) {
        	Users user = uServ.getUserByName(userName);
    		String task = tServ.deleteByName(user,name);
        	log.info("deleting task..." + name);
        	m.addAttribute("task", task);
        	m.addAttribute("userName", userName);
    	}

    	Users user = uServ.getUserByName(userName);
    	Iterable<Tasks> allTasks = tServ.findAllTasksByUser(user);
//    	if(allTasks == null) {
//    		m.addAttribute("e", allTasks);
//    	}
    	m.addAttribute("list", allTasks);
		return "tasklist";
    }
}
