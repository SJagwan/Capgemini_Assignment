package com.cg.management.employeesmg.CustomException;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}

}
