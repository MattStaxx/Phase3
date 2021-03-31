package matt.TaskManagerApp.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import matt.TaskManagerApp.entities.Users;
import matt.TaskManagerApp.services.TaskService;
import matt.TaskManagerApp.services.UserService;


@Controller
public class LoginController {


	@Autowired
	TaskService tServ;
	
	@Autowired
	UserService uServ;
	
	Logger log = LoggerFactory.getLogger(LoginController.class);

    @GetMapping(value="/")
    public String showLogin() {
    	
		log.info("going to index...");
        return "index";
    }

    @RequestMapping(value="/loginform")
    public String submitLogin(ModelMap m, @RequestParam String userName, @RequestParam String password){
    	
    	log.info("start login...");
    	if(uServ.getPassword(userName, password) == false) {
    		log.info("login denied...");
    		return "denied";
    	} else {
			log.info("login success...");
	    	m.addAttribute("user", userName);
			log.info("passing user name to view..." + userName);
    	}
    	m.addAttribute("userName", userName);
    	return "home";
    }
    
    @RequestMapping(value="/register")
    public String registerUser(ModelMap m, @RequestParam String userName, @RequestParam String email, @RequestParam String password) {
		
    	log.info("Start user registration...");
    	Users user = new Users();
    	user.setName(userName);
    	user.setEmail(email);
    	user.setPassword(password);
    	uServ.save(user, userName);
    	m.addAttribute("user", user);
    	return "registersuccess";
    }
}
