package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.CakeInfo;
import com.example.demo.repositories.CakeRepo;
import com.example.demo.services.CakeService;

@RestController
@CrossOrigin(origins ="*")


public class CakeController {


	@Autowired
	CakeService cservice;
	@Autowired
	CakeRepo caker;
	
	//get all cake data using JPA getall method
	@GetMapping("/cakedata")
	public List<CakeInfo> getAll()
	{
		return cservice.getAll();
	}

	//Add cake api 
	//send data to database via addcake form
	@PostMapping("/addcakes")
	public CakeInfo save(@RequestBody CakeInfo ci)
	{
		System.out.println(ci);
		return cservice.save(ci);
	}
	
	
	//update
	
	@GetMapping("/cakedata/{id}")
	public CakeInfo getcakeinfoById(@PathVariable Integer id) {
		return caker.findById(id).get();
	}
	
	//Update cake restapi
	@PutMapping("/cakedata")
	public CakeInfo updatecakeinfo(@RequestBody CakeInfo cakeinfo) {
		return caker.save(cakeinfo);
	}
	
	//Delete cake api using cakeid
	@DeleteMapping("/cakedata/{id}")
	public ResponseEntity<HttpStatus> deletecakeinfoById(@PathVariable Integer id) {
		caker.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	

	
}


