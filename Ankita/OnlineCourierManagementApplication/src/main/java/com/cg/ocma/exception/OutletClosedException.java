package com.cg.ocma.exception;

public class OutletClosedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public OutletClosedException(String errorMsg) {
		super(errorMsg);
		
	}

}