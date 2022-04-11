package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.dto.LoginDto;
import com.example.demo.entites.Login;
import com.example.demo.services.LoginService;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
public class LoginController {

	@Autowired 
	LoginService lservice;
	
	@GetMapping("/checkLogin")
	public String checkLogin(@RequestParam("uid") String uid, @RequestParam("pwd") String pwd)
	{
		return lservice.checkLogin(uid, pwd);
	}
	
	
	@PostMapping("/userLogin")
	@JsonInclude(Include.NON_NULL)
	public @ResponseBody LoginDto userLogin(@RequestBody Login loginUser) {

		List<Login> users = lservice.getAllUserDtlss();
		LoginDto loDto = new LoginDto();
		System.out.println("loginUser: " + loginUser.toString());
		for (Login usr : users) {
			if (usr.getUid().equals(loginUser.getUid())
					&& usr.getPwd().equals(loginUser.getPwd())) {
				System.out.println("Valid User!");
				loDto.setStatus("SUCCESS");
				loDto.setUsername(usr.getUser());
				loDto.setPassword(usr.getPwd());
				loDto.setUserId(usr.getUid());
				loDto.setMessage("LOGIN_SUCCESSFULLY");
				return loDto;
			}
		}

		loDto.setStatus("ERROR");
		loDto.setMessage("INVALID_USER_NAME_OR_PASSWORD");
		return loDto;
	}
	

	@GetMapping("/getAllUser")
	public @ResponseBody List<Login> getAllUser() {

		List<Login> users = lservice.getAllUserDtlss();
		return users;
	}
	
}
