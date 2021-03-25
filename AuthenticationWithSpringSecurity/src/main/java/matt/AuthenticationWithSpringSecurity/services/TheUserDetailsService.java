package matt.AuthenticationWithSpringSecurity.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import matt.AuthenticationWithSpringSecurity.entities.Roles;
import matt.AuthenticationWithSpringSecurity.entities.Users;

@Service
public class TheUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String name) {
		
		Users user = userService.findByUserName(name);
		List<GrantedAuthority> authorities = getUserAuthority(user.getRoles());
		return buildUserForAuthentication(user, authorities);
	}
	
	private List<GrantedAuthority> getUserAuthority(Set<Roles> userRoles) {
		
		Set<GrantedAuthority> roles = new HashSet<>();
		for(Roles r : userRoles) {
			roles.add(new SimpleGrantedAuthority(r.getRole()));
		}
		return null;
	}
	
	public UserDetails buildUserForAuthentication(Users user, List<GrantedAuthority> authorities) {
		
		return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), user.getActive(), true, true, true, authorities);
	}
}
