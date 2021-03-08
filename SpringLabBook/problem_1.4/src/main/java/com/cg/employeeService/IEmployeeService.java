package com.cg.employeeService;

import java.util.List;

import com.cg.employeeBean.Employee;

public interface IEmployeeService {
	
	public void add(String name , double salary);
	
	public List<Employee> displayAll();

}
