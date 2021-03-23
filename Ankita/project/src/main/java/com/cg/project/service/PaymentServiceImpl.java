package com.cg.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.repository.CustomerRepo;

@Service
public class PaymentServiceImpl implements IPaymentService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private EMParser parser;

	public PaymentServiceImpl() {
		/* No implementation */
	}

	public PaymentServiceImpl(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
		this.parser=new EMParser();
	}

	@Override
	public boolean processByCash() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean processByCard() {
		// TODO Auto-generated method stub
		return false;
	}

}
