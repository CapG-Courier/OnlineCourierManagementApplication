package com.cg.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.project.entity.OfficeStaffMembers;

@Repository
public interface ManagerRepo extends JpaRepository <OfficeStaffMembers, Integer>{
	
	public List<OfficeStaffMembers> findAllByOfficeId(int officeid);

}
