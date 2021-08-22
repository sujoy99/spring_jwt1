package org.itbl.controller;

import org.itbl.entity.JwtRequest;
import org.itbl.entity.JwtResponse;
import org.itbl.service.CustomUserDetails;
import org.itbl.service.CustomUserDetailsService;
import org.itbl.utility.JwtUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class MainController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	
	@Autowired
	private JwtUtility jwtUtility;

	@PostMapping("/test")
	public ResponseEntity<?> test() {
		
		return ResponseEntity.ok("hello world");
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> authenticate(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		System.out.println("jwt request =" + jwtRequest);
		
		try {
			
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken( jwtRequest.getUsername(), jwtRequest.getPassword())
					);
			
		}catch(BadCredentialsException e){
			
			throw new Exception("Invalid Credintial", e);
		}
		
		
		CustomUserDetails userDetails = customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		
		final String token = jwtUtility.generateToken1(userDetails);
		
		System.out.println("token = "+ token);
		
		return ResponseEntity.ok(new JwtResponse(token));
	}
}
