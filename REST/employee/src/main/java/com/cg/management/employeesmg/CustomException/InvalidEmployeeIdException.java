package com.cg.management.employeesmg.CustomException;

public class InvalidEmployeeIdException extends RuntimeException {
	public InvalidEmployeeIdException(String msg) {
		super(msg);
	}

}
