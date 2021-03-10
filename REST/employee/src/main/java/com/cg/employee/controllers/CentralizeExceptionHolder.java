package com.cg.employee.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.employee.CustomException.EmployeeNotFoundException;
import com.cg.employee.CustomException.InvalidEmployeeIdException;
import com.cg.employee.CustomException.InvalidEmployeeNameException;



@RestControllerAdvice
public class CentralizeExceptionHolder {
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EmployeeNotFoundException.class)
    public String handleStudentNotFound(EmployeeNotFoundException e){
        return  e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidEmployeeNameException.class)
    public  String handleInvalidName(InvalidEmployeeNameException e){
        return e.getMessage();
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidEmployeeIdException.class)
    public  String handleInvalidName(InvalidEmployeeIdException e){
        return e.getMessage();
    }

}
