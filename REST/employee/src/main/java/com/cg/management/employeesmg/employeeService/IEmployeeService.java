package com.cg.management.employeesmg.employeeService;

import java.util.List;

import com.cg.management.employeesmg.employeeBean.Employee;

public interface IEmployeeService {
	
	public void add(String name , double salary);
	
	public Employee findById(int id);
	
	public void removeEmployee(int id);
	
	public void updateName(int id, String name);
	
	public List<Employee> fetchAll();

}
