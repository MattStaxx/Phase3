package matt.usermanager.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.slf4j.LoggerFactory;

import matt.usermanager.entities.Users;
import matt.usermanager.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@GetMapping(value = "/")
    public String showIndexPage(ModelMap model, @RequestParam(value="name", required=false, defaultValue="World") String name) {

		logger.info("Starting app...");
		model.addAttribute("name", name);
		return "users";
	} 
	
	@GetMapping("/users")
	public String showUsers(ModelMap model) {
		
		logger.info("Getting all users...");
		Iterable<Users> users = userService.getAllUsers();
		logger.info("Passing users to view");
		model.addAttribute("users", users);
		return "queryUserInput";
	}

	@RequestMapping(value="/queryUserInput", method=RequestMethod.POST)
	public String getUserById(ModelMap model, @RequestParam int id) {
		
		logger.info("Retirieving user...");
		Users u = userService.getUserById(id);
		List<Users> list = new ArrayList<>();
		list.add(u);
		logger.info("Passing user to view");
		model.addAttribute("user", list);
		return "editUserInput";
	}
	
	@RequestMapping(value="/editUserInput", method=RequestMethod.POST)
	public String updateUser(ModelMap model, @RequestParam int id, @RequestParam String name, @RequestParam String email, @RequestParam String password) {
		
		Users user = new Users();
		logger.info("Setting user data...");
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		userService.save(user);
		List<Users> list = new ArrayList<>();
		list.add(user);
		logger.info("Passing user to view");
		model.addAttribute("user", list);
		return "editSuccess";
	}
}
