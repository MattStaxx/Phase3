package matt.AuthenticationWithSpringSecurity.services;

import java.util.Arrays;
import java.util.HashSet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import matt.AuthenticationWithSpringSecurity.entities.Roles;
import matt.AuthenticationWithSpringSecurity.entities.Users;
import matt.AuthenticationWithSpringSecurity.repositories.RoleRepository;
import matt.AuthenticationWithSpringSecurity.repositories.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	Logger log = LoggerFactory.getLogger(TheUserDetailsService.class);
	
	@Autowired
	public UserService(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	public Users findUserByEmail(String email) {
		
		return userRepository.findUserByEmail(email);
	}
	
	public Users findUserByUserName(String userName) {
		
		return userRepository.findByUserName(userName);
	}
	
	public Users saveUser(Users user) {

		log.info("saving user..." + user);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(true);
		Roles userRole = roleRepository.findByRole("ADMIN");
		user.setRoles(new HashSet<Roles>(Arrays.asList(userRole)));
		return userRepository.save(user);
	}
}
