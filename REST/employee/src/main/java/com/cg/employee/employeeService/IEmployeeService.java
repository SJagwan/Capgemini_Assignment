package com.cg.employee.employeeService;

import java.util.List;

import com.cg.employee.employeeBean.Employee;

public interface IEmployeeService {
	
	public void add(String name , double salary);
	
	public Employee findById(int id);
	
	public Employee removeEmployee(int id);
	
	public void updateName(int id, String name);
	
	public List<Employee> fetchAll();

}
