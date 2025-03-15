package com.security.springsecurity.controller;//package com.example.springsecurity.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController
{
	@GetMapping("/home")
	public String greet(HttpServletRequest req)
	{
		return "Hello" +req.getSession().getId();
	}
}
