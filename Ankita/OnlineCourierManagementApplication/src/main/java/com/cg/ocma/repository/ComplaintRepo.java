package com.cg.ocma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.ComplaintEntity;

@Repository
public interface ComplaintRepo extends JpaRepository <ComplaintEntity,Integer>{
	
	public boolean existsByConsignmentNo(int consignmentNo);
	
	@Query(value = "SELECT * FROM complaint WHERE customer_id = :customerid", nativeQuery = true)
	public List<ComplaintEntity> findAllByCustomerId(int customerId);

}
