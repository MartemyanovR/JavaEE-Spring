package ru.mart.springInit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ru.mart.springInit.model.User;
import ru.mart.springInit.repository.UserRepository;

@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {

	private final UserRepository repository;
	
	@Autowired
	public UserDetailsServiceImpl(UserRepository repository) {
		this.repository = repository;		
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = repository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User doesn't exists"));
		return SecurityUser.fromUser(user);
	}

}
