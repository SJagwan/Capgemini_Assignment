package com.cg.empmgt.exceptions;

public class InvalidEmployeeIdException extends RuntimeException {
	public InvalidEmployeeIdException(String msg){
		super(msg);
	}

}
