package com.security.springsecurity.config;//package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig
{
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
}
