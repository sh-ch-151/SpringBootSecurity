package com.security.springsecurity.controller;//package com.example.springsecurity.controller;

import com.security.springsecurity.entity.Users;
import com.security.springsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController
{
	@Autowired
	private UserService serv;

	@PostMapping("/register")
	public Users register(@RequestBody Users user)
	{
		return serv.register(user);
	}

	@PostMapping("/login")
	public String login(@RequestBody Users user)
	{
		return serv.verify(user);
	}
}
