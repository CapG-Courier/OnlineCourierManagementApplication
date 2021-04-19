package com.cg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.AddressEntity;
import com.cg.ocma.model.AddressModel;

@Repository
public interface AddressRepo extends JpaRepository <AddressEntity,Integer>{
	
	public boolean existsByHouseNo(String houseNo);
	public AddressModel findByCustomerId(int customerId);
	public AddressModel findByOfficeId(int officeId);

}