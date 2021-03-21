package matt.authenticaiton.services;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matt.authenticaiton.entities.Users;
import matt.authenticaiton.exceptions.UserNotFoundException;
import matt.authenticaiton.repositories.UserRepository;




@Service
public class UserService {

	Logger log = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	 private UserRepository userRepository;

    public Iterable<Users> getAllUsers()
    {
        return userRepository.findAll();
    }


    public Users getUserByName(String name) {
    	
    	Optional<Users> foundUser = userRepository.findByName(name);
    	log.info("searching for user...");
    	
    	if(!foundUser.isPresent()) {
    		throw new UserNotFoundException();
    	}

    	log.info("found user...");
    	return (foundUser.get());
    }
    
    public boolean getPassword(String username, String password) {
    	
    	boolean status = false;
    	Users user = getUserByName(username);
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
}