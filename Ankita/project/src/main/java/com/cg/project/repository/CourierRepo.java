package com.cg.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.Courier;
import com.cg.project.entity.Customer;

@Repository
public interface CourierRepo extends JpaRepository <Courier,Integer>{
	
	@Query("SELECT c FROM Customer c WHERE (SELECT customerid FROM Courier WHERE courierid = ?)")
	public Customer findCustomer(int courierid);
	public Courier findByConsignmentNo(int consignmentno);
	public boolean existsByConsignmentNo(int consignmentno);

}
