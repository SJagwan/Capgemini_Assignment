package com.cg.employee.CustomException;

public class EmployeeNotFoundException extends RuntimeException {
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}

}
