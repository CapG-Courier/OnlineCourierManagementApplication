package com.cg.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.project.entity.Complaint;

@Repository
public interface ComplaintRepo extends JpaRepository <Complaint,Integer>{
	
	public List<Complaint> findAllByCustomerId(int customerid);

}
