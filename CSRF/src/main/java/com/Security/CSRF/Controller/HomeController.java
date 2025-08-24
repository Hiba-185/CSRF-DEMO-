package com.Security.CSRF.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Security.CSRF.Model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class HomeController {
	
	@GetMapping("/")
	public String hello() {
		return "Hello world";
	}
	
	List <Student> students= new ArrayList<>(Arrays.asList( new Student(1,"Hiba","7891"),new Student(2,"Shazile","sh345")));
	
	@GetMapping("Allstudents")
	public List<Student> getAllDetails(){
		return students;
	}
	
	@PostMapping("student")
	public void addstudent(@RequestBody Student student) {
		students.add(student);
	}
	
	@GetMapping("csrf-token")
	public CsrfToken getCsrftoken(HttpServletRequest request) {
		return (CsrfToken) request.getAttribute("_csrf");
		
	}
	

}
