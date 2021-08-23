package org.itbl.config;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.itbl.JwtFilter;
import org.itbl.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtFilter jwtFilter;
	

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Add a filter to validate the tokens with every request
				http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
		
		
		http
			.cors().and()
			.csrf().disable()
			.authorizeRequests()
			.antMatchers(HttpMethod.POST, "/authenticate").permitAll()
			.anyRequest().authenticated()
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//			.and()
//			.addFilterBefore(UsernamePasswordAuthenticationFilter.class, jwtFilter);
		
		
	}
	
	
	//and cors configuration
//  @Bean
//  CorsConfigurationSource corsConfigurationSource() {
//      CorsConfiguration configuration = new CorsConfiguration();
//
//      configuration.setAllowedOrigins(Collections.singletonList("http://localhost:3000"));
//      configuration.setAllowedHeaders(List.of("*"));
//      configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE"));
//      configuration.setAllowCredentials(true);
//
//      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//      source.registerCorsConfiguration("/**", configuration);
//
//      return source;
//  }

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	

	
	
	
	
}
