package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entites.complaint;
 


	@Repository
	public interface complaintrepo extends JpaRepository<complaint,Long> {
		

	}

