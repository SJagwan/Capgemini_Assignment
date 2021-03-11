package com.cg.management.employeesmg.CustomException;

public class InvalidEmployeeNameException extends RuntimeException {
	public InvalidEmployeeNameException(String msg) {
		super(msg);
	}

}
