package matt.AuthenticationWithSpringSecurity.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
//import javax.validation.Valid;

import matt.AuthenticationWithSpringSecurity.entities.Users;
import matt.AuthenticationWithSpringSecurity.services.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value= {"/", "/login"})
	public ModelAndView login() {
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@GetMapping(value="/registration")
	public ModelAndView registration() {

		ModelAndView modelAndView = new ModelAndView();
		Users user = new Users();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@PostMapping(value="/registration")
	public ModelAndView createNewUser(@Validated Users user, BindingResult bindingResult) {

		ModelAndView modelAndView = new ModelAndView();
		Users userExists = userService.findByUserName(user.getName());
		if(userExists != null) {
			bindingResult
					.rejectValue("name", "error.user", "That user name is already registered");
		}
		if(bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User registration success");
			modelAndView.addObject("user", new Users());
			modelAndView.setViewName("registration");
		}
		return modelAndView;
	}
	
	@GetMapping(value="/admin/home")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Users user = userService.findByUserName(auth.getName());
		modelAndView.addObject("name", "Welcome " + user.getName() + "/" + user.getName() + " " + " (" + user.getEmail() + ") ");
		modelAndView.addObject("adminMessage", "This content is only available to administrators");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}
}
