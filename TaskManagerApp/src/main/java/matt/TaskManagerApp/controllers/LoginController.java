package matt.TaskManagerApp.controllers;

import java.sql.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import matt.TaskManagerApp.entities.Tasks;
import matt.TaskManagerApp.entities.Users;
import matt.TaskManagerApp.services.TaskService;
import matt.TaskManagerApp.services.UserService;


@Controller
public class LoginController {

	@Autowired
	UserService uServ;
	@Autowired
	TaskService tServ;
	
	Logger log = LoggerFactory.getLogger(LoginController.class);
	

//    @GetMapping("/")
//    public String showGreeting() {
//    	
//    	log.info("Starting app...");
//        return "index";
//    }

    @GetMapping(value="/")
    public String showLogin() {
    	
		log.info("going to home...");
        return "home";
    }

    @RequestMapping(value="/loginform")
    public String submitLogin(ModelMap m, @RequestParam String username, @RequestParam String password){
    	
    	log.info("start login...");
    	if(uServ.getPassword(username, password) == false) {
    		log.info("login denied...");
    		return "denied";
    	} else {
			log.info("login success...");
	    	m.addAttribute("user", username);
			log.info("passing user name to view..." + username);
    	}
        	return "taskform";
    }
    
    @RequestMapping(value="/register")
    public String registerUser(ModelMap m, @RequestParam String username, @RequestParam String email, @RequestParam String password) {
		
    	log.info("Start user registration...");
    	Users user = new Users();
    	user.setName(username);
    	user.setEmail(email);
    	user.setPassword(password);
    	uServ.save(user);
    	m.addAttribute("user", user);
    	return "registersuccess";
    }
    
    @RequestMapping("/accessdenied")
    public String denied() {
    	
    	return "denied";
    }

    @RequestMapping(value="/success")
    public String success() {

    	return "managetask";
    }
    
    @RequestMapping(value="/manage")
    public String addTask(ModelMap m, @RequestParam String name, @RequestParam Date start, @RequestParam Date end,
    								 @RequestParam String desc, @RequestParam String sev, @RequestParam String username) {

    	log.info("start add tasks..." + username);
    	Users user = uServ.getUserByName(username);
    	Tasks task = new Tasks();
    	task.setName(name);
    	task.setStart(start);
    	task.setEnd(end);
    	task.setDesc(desc);
    	task.setSeverity(sev);
    	task.setUser(user);  // import a hidden user object to the form to link to the logged in user
    	m.addAttribute("task", task);
    	m.addAttribute("user", username);
    	tServ.save(task);
    	
		return "tasklist";
    }

    
}
