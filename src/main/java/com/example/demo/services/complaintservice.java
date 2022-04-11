package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.entites.complaint;

import com.example.demo.repositories.complaintrepo;

@Service
public class complaintservice {
	@Autowired
	complaintrepo comrepo;
	
	public complaint save(complaint com)
	{
		return comrepo.save(com);
	}
	
	
}
