package com.cg.employee.CustomException;

public class InvalidEmployeeIdException extends RuntimeException {
	public InvalidEmployeeIdException(String msg) {
		super(msg);
	}

}
