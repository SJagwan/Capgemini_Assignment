package com.cg.management.employeesmg.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.management.employeesmg.CustomException.EmployeeNotFoundException;
import com.cg.management.employeesmg.CustomException.InvalidEmployeeIdException;
import com.cg.management.employeesmg.CustomException.InvalidEmployeeNameException;



@RestControllerAdvice
public class CentralizeExceptionHolder {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleEmployeeNotFound(EmployeeNotFoundException e){
        return  e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidEmployeeNameException.class)
    public  String handleInvalidEmployeeName(InvalidEmployeeNameException e){
        return e.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidEmployeeIdException.class)
    public  String handleInvalidEmployeeId(InvalidEmployeeIdException e){
        return e.getMessage();
    }

}
