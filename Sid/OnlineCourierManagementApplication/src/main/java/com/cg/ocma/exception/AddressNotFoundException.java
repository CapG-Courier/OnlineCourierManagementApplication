package com.cg.ocma.exception;
public class AddressNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public AddressNotFoundException(String errorMsg) {
		super(errorMsg);
	}

}