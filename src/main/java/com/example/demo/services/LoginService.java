package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entites.CakeInfo;
import com.example.demo.entites.Login;
import com.example.demo.repositories.LoginRepo;

@Service
public class LoginService {
	@Autowired
	LoginRepo lrepo;
	public String checkLogin(String uid,String pwd)
	{
		return lrepo.checkLogin(uid, pwd);
	}
	
	//getting all UserDtls record by using the method findaAll() of CrudRepository  
		public List<Login> getAllUserDtlss() {
			List<Login> sserDtlss = new ArrayList<Login>();
			lrepo.findAll().forEach(userDtls1 -> sserDtlss.add(userDtls1));  
			System.out.println(sserDtlss);
			return sserDtlss;
		}

		public Login save(Login ci)
		{
			return lrepo.save(ci);
			
		}
}
