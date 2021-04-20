package com.cg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.AddressEntity;

@Repository
public interface AddressRepo extends JpaRepository <AddressEntity,Integer>{
	
	public boolean existsByHouseNo(String houseNo);
	
	@Query(value = "SELECT * FROM address WHERE customer_id = :customerId", nativeQuery = true)
	public AddressEntity findByCustomerId(@Param("customerId") int customerId);
	
	@Query(value = "SELECT * FROM address WHERE office_id = :officeId", nativeQuery = true)
	public AddressEntity findByOfficeId(@Param("officeId") int officeId);

}