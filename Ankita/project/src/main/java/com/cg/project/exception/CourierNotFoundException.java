package com.cg.project.exception;
public class CourierNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public CourierNotFoundException(String errorMsg) {
		super(errorMsg);
	}
}