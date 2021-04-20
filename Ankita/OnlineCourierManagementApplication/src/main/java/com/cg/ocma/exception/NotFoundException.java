package com.cg.ocma.exception;
public class NotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String errorMsg) {
		super(errorMsg);
	}

}