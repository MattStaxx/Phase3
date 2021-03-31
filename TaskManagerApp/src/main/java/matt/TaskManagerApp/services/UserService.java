package matt.TaskManagerApp.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matt.TaskManagerApp.entities.Users;
import matt.TaskManagerApp.exceptions.UserNameAlreadyExistsException;
import matt.TaskManagerApp.exceptions.UserNotFoundException;
import matt.TaskManagerApp.repositories.UserRepository;

@Service
public class UserService {

	Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserRepository userRepository;

    	public Iterable<Users> getAllUsers() {
    		
	        return userRepository.findAll();
	    }
    
    public Users getUserByName(String userName) {
    	
    	Optional<Users> foundUser = userRepository.findByName(userName);
    	log.info("searching for user...");
    	
    	if(!foundUser.isPresent()) {
        	log.info("user not found...");
    		throw new UserNotFoundException();
    	}

    	log.info("found user...");
    	return (foundUser.get());
    }
    
    public boolean getPassword(String userName, String password) {
    	
    	boolean status = false;
    	Users user = getUserByName(userName);
    	log.info("***" + user.getName() + "***");
    	log.info("***" + user.getPassword() + "***");
    	if(user.getPassword().equals(password)) {
        	log.info("password match...");
    		status = true;
    	} else {
        	log.info("no password match..."); 
    		status = false;
    	}
    	return status;
    }
    
    public Users save(Users user, String userName) {
    	
    	if(getAllUsers() == null) {
        	return userRepository.save(user);
    	} else if(getUserByName(userName) != null) {
    		throw new UserNameAlreadyExistsException();
    	} else {
    		return userRepository.save(user);
    	}
    	
    }
}
