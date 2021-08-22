package org.itbl.service;

import java.util.Collection;
import java.util.Collections;

import org.itbl.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	
	

	public CustomUserDetails(User user) {
		super();
		this.user = user;
	}
	
	public User getUser() {
		
		System.out.println("Custom User Details = " + user);
		return user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		
		return Collections.singleton(new SimpleGrantedAuthority(user.getUserType().getTypeId().toString()));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	
	
}
