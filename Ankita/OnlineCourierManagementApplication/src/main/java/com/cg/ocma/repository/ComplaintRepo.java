package com.cg.ocma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.ComplaintEntity;
import com.cg.ocma.model.ComplaintModel;


@Repository
public interface ComplaintRepo extends JpaRepository <ComplaintEntity,Integer>{
	
	public boolean existsByConsignmentNo(int consignmentNo);
	public List<ComplaintModel> findAllByCustomerId(int customerId);

}
