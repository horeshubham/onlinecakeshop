package com.example.demo.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entites.CakeInfo;
import com.example.demo.entites.complaint;
import com.example.demo.repositories.complaintrepo;
import com.example.demo.services.complaintservice;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/api")
public class Complaintcontroller {
	
	
@Autowired
private complaintrepo complaints;

@Autowired
private complaintservice comserv;
	
    //get all customer complaints using JPA getall method
	@GetMapping("/complaints")
	public List <complaint> Getallcomplaint(){
		return complaints.findAll();
				
	}
	
	//Add complaint api 
   //send data to database via addcomplaints form
	@PostMapping("/addcomplaints")
	public complaint save(@RequestBody complaint com)
	{
		System.out.println(com);
		return comserv.save(com);
	}

	//update and delete
	@GetMapping("/complaints/{id}")
	public complaint getcomplaintsById(@PathVariable Long id) {
		return complaints.findById(id).get();
	}
	
	//Delete complaint api using cakeid
	@DeleteMapping("/complaints/{id}")
	public ResponseEntity<HttpStatus> deletecomplaintsById(@PathVariable Long id) {
		complaints.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
	
