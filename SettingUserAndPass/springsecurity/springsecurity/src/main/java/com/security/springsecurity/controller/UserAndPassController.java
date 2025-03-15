package com.security.springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserAndPassController {
	
	@GetMapping("/home")
	public String getResult(HttpServletRequest req)
	{
		return "Hello" + req.getSession().getId();
	}
}
