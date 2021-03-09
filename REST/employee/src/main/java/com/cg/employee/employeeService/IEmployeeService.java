package com.cg.employee.employeeService;

import java.util.List;

import com.cg.employee.employeeBean.Employee;

public interface IEmployeeService {
	
	public void add(String name , double salary);
	
	public List<Employee> displayAll();

}
