package com.cg.ocma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.Complaint;

@Repository
public interface ComplaintRepo extends JpaRepository <Complaint,Integer>{
	
	@Query("SELECT c FROM complaint WHERE customerid = :customerid")
	public List<Complaint> findAllComplaintsByCustomerId(int customerid);

}
