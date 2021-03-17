package matt.usermanager.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matt.usermanager.entities.Users;
import matt.usermanager.exceptions.UserNotFoundException;
import matt.usermanager.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Iterable<Users> getAllUsers() {

		return userRepository.findAll();
	}
	
	public Users getUserByName(String name) {
		
		Users foundUser = userRepository.findByName(name);
		return foundUser;
	}
	
	public Users getUserById(int id) {
		
		Optional<Users> foundUser = userRepository.findById(id);
		if(!foundUser.isPresent()) {
			throw new UserNotFoundException();
		}
		return (foundUser.get());
	}
	
	public Users save(Users user) {

		Users foundUser = userRepository.save(user);
		
		return foundUser;
	}
}
