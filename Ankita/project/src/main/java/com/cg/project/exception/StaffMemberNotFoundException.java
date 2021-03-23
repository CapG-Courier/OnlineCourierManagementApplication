package com.cg.project.exception;
public class StaffMemberNotFoundException extends Exception {
private static final long serialVersionUID=1L;
	
	public StaffMemberNotFoundException(String errorMsg) {
		super(errorMsg);
	}
	

}