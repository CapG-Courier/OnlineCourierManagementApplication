package com.cg.ocma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.CourierEntity;
import com.cg.ocma.model.CourierModel;

@Repository
public interface CourierRepo extends JpaRepository <CourierEntity,Integer>{
	
	public CourierEntity findByConsignmentNo(int consignmentno);
	public boolean existsByConsignmentNo(int consignmentno);
	public List<CourierModel> findAllByCustomerId(int customerId);

}
