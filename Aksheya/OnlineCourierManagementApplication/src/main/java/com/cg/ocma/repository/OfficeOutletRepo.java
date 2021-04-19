package com.cg.ocma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.ocma.entities.CourierOfficeOutletEntity;

@Repository
public interface OfficeOutletRepo  extends JpaRepository <CourierOfficeOutletEntity,Integer>{

}
