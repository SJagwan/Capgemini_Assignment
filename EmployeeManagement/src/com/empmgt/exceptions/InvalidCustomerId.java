package com.empmgt.exceptions;

public class InvalidCustomerId extends RuntimeException {
	public InvalidCustomerId(String msg)
	{
		super(msg);
	}

}
