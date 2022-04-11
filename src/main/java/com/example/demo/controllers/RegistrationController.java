package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.Login;
import com.example.demo.entites.Registration;
import com.example.demo.services.LoginService;
import com.example.demo.services.RegistrationService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")

public class RegistrationController {

	@Autowired
	RegistrationService rservice;

	@Autowired
	LoginService lservice;

	@GetMapping("/GetData")
	public List<Registration> getAll() {
		return rservice.getAll();
	}

	@PostMapping("/Register")
	public Registration save(@RequestBody Registration rs)

	{
		Login user = new Login();
		System.out.println(rs);

		Registration registeruser = rservice.save(rs);
		if (registeruser != null) {
			user.setUser(registeruser.getUsertype());
			user.setUid(registeruser.getEmail());
			user.setPwd(registeruser.getPassword());
			lservice.save(user);
		}
		return registeruser;

	}

	@GetMapping("/check")
	public String check(@RequestParam("email") String email, @RequestParam("password") String password) {
		return rservice.check(email, password);
	}

	@GetMapping("/custMail/{email}")
	public int getInt(@PathVariable String email) {
		return rservice.getCustomerId(email);
	}
}
