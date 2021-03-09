package com.cg.employee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.employee.employeeBean.Employee;
import com.cg.employee.employeeService.EmployeeService;

@RequestMapping("/employees")
@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	
	
	@GetMapping()
	public List<Employee> allEmployee(){
	List<Employee>e=employeeService.displayAll();
	return e;
	}
	
	@PostMapping("/add")
	public String addEmployee(@RequestBody Employee requestData) {
	   employeeService.add(requestData.getEmpName(),requestData.getSalary());
	   return "new employee added";
	}

}
