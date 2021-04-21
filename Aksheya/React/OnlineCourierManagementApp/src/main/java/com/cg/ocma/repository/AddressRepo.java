package com.cg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.AddressEntity;

@Repository
public interface AddressRepo extends JpaRepository <AddressEntity,Integer>{
	
	public boolean existsByHouseNo(String houseno);
	
	@Query(value = "SELECT * FROM address WHERE customerid = :customerid", nativeQuery = true)
	public AddressEntity findByCustomerId(@Param("customerid") int customerid);

}
