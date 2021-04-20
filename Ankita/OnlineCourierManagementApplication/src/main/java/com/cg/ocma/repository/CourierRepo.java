package com.cg.ocma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.CourierEntity;

@Repository
public interface CourierRepo extends JpaRepository <CourierEntity,Integer>{
	
	public CourierEntity findByConsignmentNo(int consignmentno);
	public boolean existsByConsignmentNo(int consignmentno);
	
	@Query(value = "SELECT * FROM courier WHERE customer_id = :customerid", nativeQuery = true)
	public List<CourierEntity> findAllByCustomerId(int customerId);

}
