package com.security.springsecurity.config;//package com.example.springsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
		@Autowired
	UserDetailsService userService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
	{
		/*This is first step*/
//		http.csrf(customizer -> customizer.disable());
//		http.authorizeHttpRequests(req -> req.anyRequest().authenticated());
//		http.formLogin(Customizer.withDefaults());//THis is for login form
//		http.httpBasic(Customizer.withDefaults());//This is for post man
//		http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));//Session stateless
//		return http.build();

		/*This is second step*/
		return http
			.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(req -> req
			.requestMatchers("register", "login")//Request matcher is used for no authentication if we set NO aauth in post then it uses request mmatcher with permitAll()
			.permitAll()//This is to used for take permission without permission it will pass
			.anyRequest().authenticated())//This is nothing but authentication
			.httpBasic(Customizer.withDefaults())
			.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			.build();
	}
	
	
	//TODO This implementation is default user and password
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		UserDetails user1 = User
//			.withDefaultPasswordEncoder()//dont used in development
//			.username("kiran")
//			.password("kiran")
//			.roles("USER")
//			.build();
//
//		UserDetails user2 = User
//			.withDefaultPasswordEncoder()//dont used in development
//			.username("shweta")
//			.password("vivek")
//			.roles("USER")
//			.build();
//		return new InMemoryUserDetailsManager(user1, user2);
//	}
	
	
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		provider.setUserDetailsService(userService);
		return provider;
	}
}
