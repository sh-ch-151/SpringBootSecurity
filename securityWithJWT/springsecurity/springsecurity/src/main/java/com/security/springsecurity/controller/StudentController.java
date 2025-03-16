package com.security.springsecurity.controller;//package com.example.springsecurity.controller;

import com.security.springsecurity.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController
{
	List<Student> sdts = new ArrayList<>();
	
	@GetMapping("/stds")
	public List<Student> geList()
	{
		return getStList();
	}

	@GetMapping("/csrf")
	public CsrfToken getToken(HttpServletRequest req)
	{
		return (CsrfToken) req.getAttribute("_csrf");
	}

	@PostMapping("/stds")
	public Student getStudent(@RequestBody Student student)
	{
		Student std = student;
		sdts.add(std);
		return std;
	}

	private List<Student> getStList()
	{
		sdts =
			new ArrayList<>(List.of(new Student(1, "Shweta", 23), new Student(2, "Pooja", 24)));
		return sdts;
	}
}
