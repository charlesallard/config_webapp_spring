package com.projet.webapp;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.projet.bdd.UserDAO;

@Component
public class AuthenticationService implements UserDetailsService {

	@Autowired
	private UserDAO userRepository;

	@Override
	public UserDetails loadUserByUsername(final String username) {
		Optional<User> option = userRepository.findOneByLogin(username);
		if (option.isPresent()) {
			User user = option.get();
			List<GrantedAuthority> rules = new ArrayList<GrantedAuthority>();
			rules.add(new SimpleGrantedAuthority("READ"));
			if (user.getEmail().equals("tominho@gmail.com")) {
				rules.add(new SimpleGrantedAuthority("WRITE"));
			}
			
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), rules);
		}

		throw new UsernameNotFoundException("username.not.found");
	}
}
