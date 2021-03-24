package com.cg.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.project.model.CustomerModel;
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
		
		return true;
	}

	@Override
	public boolean processByCard(int customerid) {
		
		boolean flag = false;
		
		if(customerRepo.existsById(customerid)) {
			
			if(parser.parse(customerRepo.findById(customerid).orElse(null)).getAcct() != null) {
				flag = true;
				
			}else {
				
				flag = false;
			}
			
		}
		
		return flag;
	}

}
