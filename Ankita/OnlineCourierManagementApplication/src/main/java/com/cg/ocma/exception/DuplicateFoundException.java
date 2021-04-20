package com.cg.ocma.exception;

public class DuplicateFoundException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateFoundException(String errorMsg) {
		super(errorMsg);
	}

}