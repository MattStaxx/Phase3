package matt.authenticaiton.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import matt.authenticaiton.services.UserService;



@Controller
public class LoginController {

	@Autowired
	UserService uServ;
	Logger log = LoggerFactory.getLogger(LoginController.class);
	

    @GetMapping("/")
    public String showGreeting(ModelMap map) {
    	
        return "index";
    }


    @GetMapping("/index")
    public String showLogin(ModelMap map) {
    	
		log.info("getting all users...");
        return "loginform";
    }

    @RequestMapping(value="/loginform")
    public String submitLogin(ModelMap m, @RequestParam String username, @RequestParam String password){
    	
    	log.info("start login...");
    	if(uServ.getPassword(username, password) == false) {
    		log.info("login denied...");
    		return "denied";
    	} else
		log.info("login success...");
    	m.addAttribute("user", username);
		log.info("passing user name to view...");
        return "success";
    }
    
    @RequestMapping("/accessdenied")
    public String denied() {
    	
    	return "denied";
    }

    @RequestMapping(value="/successful")
    public String success() {

    	return "success";
    }
}

