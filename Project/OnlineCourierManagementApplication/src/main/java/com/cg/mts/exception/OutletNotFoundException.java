package com.cg.mts.exception;

public class OutletNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public OutletNotFoundException(String errorMsg) {
		super(errorMsg);
	}

}
