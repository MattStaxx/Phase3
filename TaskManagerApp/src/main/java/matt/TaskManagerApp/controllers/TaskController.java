package matt.TaskManagerApp.controllers;


import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
    
    @RequestMapping(value="/manage")
    public String addTask(ModelMap m, @RequestParam String name, @RequestParam Date start, @RequestParam Date end,
    								  @RequestParam String desc, @RequestParam String sev, @RequestParam String act, @RequestParam String username) {

    	if(act.equals("create")) {

        	log.info("start add tasks..." + username);
        	Users user = uServ.getUserByName(username);
        	Tasks task = new Tasks();
        	task.setName(name);
        	task.setStart(start);
        	task.setEnd(end);
        	task.setDesc(desc);
        	task.setSeverity(sev);
        	task.setUser(user);
        	m.addAttribute("task", task);
        	m.addAttribute("user", username);
        	tServ.save(task);
    	}
    	
    	if(act.equals("update")) {

        	log.info("start update tasks..." + username);
        	Users user = uServ.getUserByName(username);
        	Tasks task = new Tasks();
        	task.setName(name);
        	task.setStart(start);
        	task.setEnd(end);
        	task.setDesc(desc);
        	task.setSeverity(sev);
        	task.setUser(user);
        	m.addAttribute("task", task);
        	m.addAttribute("user", username);
        	tServ.save(task, name);
    	}
    	
    	if(act.equals("delete")) {
    		String task = tServ.deleteByName(name);
        	log.info("deleting task..." + name);
        	m.addAttribute("task", task);
    	}
		return "tasklist";
    }
}
