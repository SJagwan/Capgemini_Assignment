package com.cg.employee.CustomException;

public class InvalidEmployeeNameException extends RuntimeException {
	public InvalidEmployeeNameException(String msg) {
		super(msg);
	}

}
