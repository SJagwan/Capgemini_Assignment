package com.cg.empmgt.service;

import java.util.List;

import com.cg.empmgt.beans.Employee;

public interface IEmployeeService {
	
	Employee add(String name, String department);

	Employee findById(int id);

	void removeById(int id);

	List<Employee> findAll();

}
