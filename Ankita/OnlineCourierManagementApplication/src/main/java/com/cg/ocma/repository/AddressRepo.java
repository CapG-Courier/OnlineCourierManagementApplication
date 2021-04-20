package com.cg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.AddressEntity;

@Repository
public interface AddressRepo extends JpaRepository <AddressEntity,Integer>{
	
	public boolean existsByHouseNo(String houseNo);
	
	@Query(value = "SELECT * FROM address WHERE customer_id = :customerid", nativeQuery = true)
	public AddressEntity findByCustomerId(int customerId);
	
	@Query(value = "SELECT * FROM address WHERE office_id = :officeid", nativeQuery = true)
	public AddressEntity findByOfficeId(int officeId);

}