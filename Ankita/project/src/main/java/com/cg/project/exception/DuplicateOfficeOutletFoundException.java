package com.cg.project.exception;

public class DuplicateOfficeOutletFoundException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public DuplicateOfficeOutletFoundException(String errorMsg) {
		super(errorMsg);
	}

}
