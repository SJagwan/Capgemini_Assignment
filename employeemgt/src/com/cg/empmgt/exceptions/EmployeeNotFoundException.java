package com.cg.empmgt.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String msg){
		super(msg);
	}

}
