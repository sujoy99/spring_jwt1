package org.itbl.service;

import org.itbl.entity.User;
import org.itbl.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public CustomUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("Custom User Details Service = "+ username);
		
		User user = userRepository.findByName(username);
		
		if(user == null) {
			
			System.out.println("user not found");
			
			throw new UsernameNotFoundException("User not found");
		}
		
		return new CustomUserDetails(user);
	}

	
	
}
