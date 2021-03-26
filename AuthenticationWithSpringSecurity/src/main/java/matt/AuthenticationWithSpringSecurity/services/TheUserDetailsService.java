package matt.AuthenticationWithSpringSecurity.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import matt.AuthenticationWithSpringSecurity.entities.Roles;
import matt.AuthenticationWithSpringSecurity.entities.Users;

@Service
public class TheUserDetailsService implements UserDetailsService {

	@Autowired
	private UserService userService;

	Logger log = LoggerFactory.getLogger(TheUserDetailsService.class);
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String userName) {

		log.info("loading userby name..." + userName);
		Users user = userService.findUserByUserName(userName);
		log.info("sending user to auth..." + user);
		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
		return buildUserForAuthentication(user, authorities);
	}
	
	private List<GrantedAuthority> getUserAuthority(Set<Roles> userRoles) {
		
		log.info("getting user authority..." + userRoles);
		Set<GrantedAuthority> roles = new HashSet<>();
		for(Roles r : userRoles) {
			roles.add(new SimpleGrantedAuthority(r.getRole()));
		}
		return new ArrayList<>(roles);
	}
	
	private UserDetails buildUserForAuthentication(Users user, List<GrantedAuthority> authorities) {
		log.info("building user for auth...." + user);
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), user.getActive(), true, true, true, authorities);
	}
}
