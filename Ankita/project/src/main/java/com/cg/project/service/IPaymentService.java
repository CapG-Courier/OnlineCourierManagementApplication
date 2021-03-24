package com.cg.project.service;

public interface IPaymentService {
	
	public boolean processByCash();
	public boolean processByCard(int customerid);  

}
