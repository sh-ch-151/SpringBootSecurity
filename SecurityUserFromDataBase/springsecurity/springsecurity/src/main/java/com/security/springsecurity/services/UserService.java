package com.security.springsecurity.services;//package com.example.springsecurity.service;

import com.security.springsecurity.entity.Users;
import com.security.springsecurity.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	@Autowired
	private UserRepo repo;

	private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

	public Users register(Users user)
	{
		user.setPass(encoder.encode(user.getPass()));
		return repo.save(user);
	}
}