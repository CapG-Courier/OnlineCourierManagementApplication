package com.cg.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository <Customer,Integer>{
	
}
