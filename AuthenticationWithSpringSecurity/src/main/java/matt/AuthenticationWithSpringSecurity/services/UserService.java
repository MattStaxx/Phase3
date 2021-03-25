package matt.AuthenticationWithSpringSecurity.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import matt.AuthenticationWithSpringSecurity.entities.Roles;
import matt.AuthenticationWithSpringSecurity.entities.Users;
import matt.AuthenticationWithSpringSecurity.repositories.RoleRepository;
import matt.AuthenticationWithSpringSecurity.repositories.UserRepository;

public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public Users findUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}
	
	public Users findByUserName(String name) {
		
		return userRepository.findByUserName(name);
	}
	
	public Users saveUser(Users user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		Roles userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Roles>(Arrays.asList(userRole)));
		return userRepository.save(user);
	}
}
