package com.cg.ocma.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.ocma.repository.CourierRepo;
import com.cg.ocma.repository.CustomerRepo;

@Service
public class PaymentServiceImpl implements IPaymentService {
	
	@Autowired
	private CustomerRepo customerRepo;
	
	@Autowired
	private CourierRepo courierRepo;
	
	public PaymentServiceImpl() {
		/* No implementation */
	}

	public PaymentServiceImpl(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}

	@Override
	public boolean processByCash() {
		
		return true;
	}

	@Override
	public boolean processByCard(int courierId) {
		
		boolean flag = false;
		if(courierRepo.existsById(courierId)) {
			
			double cost = (courierRepo.findById(courierId)).orElse(null).getCost();
			int customerId = (courierRepo.findById(courierId).orElse(null).getCustomer().getCustomerid());
			double balance = (customerRepo.findById(customerId).orElse(null).getAcct().getBankBalance());
			
			if(cost <= balance) {
				
				flag = true;
			}else {
				
				flag = false;
			}
			
		}
		
		return flag;
	}

}
