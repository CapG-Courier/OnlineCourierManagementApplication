package com.cg.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.Complaint;
import com.cg.project.entity.Customer;

@Repository
public interface ComplaintRepo extends JpaRepository <Complaint,Integer>{
	
	@Query("SELECT c FROM Customer c WHERE (SELECT customerid FROM Complaint WHERE complaintid = ?)")
	public Customer findCustomer(int complaintid);

}
