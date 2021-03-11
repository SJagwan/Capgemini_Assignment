package com.cg.management.departmentmg.controllersDept;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.management.departmentmg.deptException.InvalidDepartmentNameException;

@RestControllerAdvice
public class CentralizeExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidDepartmentNameException.class)
    public  String handleInvalidDepartmentName(InvalidDepartmentNameException e){
        return e.getMessage();
    }

}
