package com.cg.management.employeesmg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.management.employeesmg.dto.AddEmployeeRequest;
import com.cg.management.employeesmg.dto.EmployeeDetails;
import com.cg.management.employeesmg.dto.EmployeeNameRequest;
import com.cg.management.employeesmg.employeeBean.Employee;
import com.cg.management.employeesmg.employeeService.EmployeeService;
import com.cg.management.employeesmg.util.EmployeeConvert;

@RequestMapping("/employees")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private EmployeeConvert convert;
	
	
	
	@GetMapping()
	public List<EmployeeDetails> allEmployee(){
	List<Employee>e=employeeService.fetchAll();
	List<EmployeeDetails> detail=convert.toDetailList(e);
	return detail;
	}
	@ResponseStatus(HttpStatus.FOUND)
	@GetMapping("/byid/{id}")
	public EmployeeDetails findEmployee(@PathVariable int id){
		Employee e=employeeService.findById(id);
	    return convert.toDetail(e);
	}
	@ResponseStatus(HttpStatus.ACCEPTED)
	@PutMapping("/update")
	public String UpdateEmployeeName(@RequestBody EmployeeNameRequest requestData){
	employeeService.updateName(requestData.getId(), requestData.getName());
	return "Employee with id-> "+ requestData.getId() +" <-Updated";
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id){
		employeeService.removeEmployee(id);
		String str="Employee with id-> "+id+" <- get removed";
	    return str;
	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public String addEmployee(@RequestBody AddEmployeeRequest requestData) {
	   employeeService.add(requestData.getName(),requestData.getSalary());
	   return "New Employee with name-> " + requestData.getName()+" <- Added Properly";
	}

}
