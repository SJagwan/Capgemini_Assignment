package com.cg.empmgt.service;

import java.util.List;
import java.util.Map;

import com.cg.empmgt.exceptions.*;
import com.cg.empmgt.beans.Employee;
import com.cg.empmgt.dao.*;


public class EmployeeServices implements IEmployeeService {
	
	IEmployeeDao dao=new EmployeeDao();
	Map<Integer,Employee>store=EmployeeStore.store;

	@Override
	public Employee add(String name, String department) {
		validateName(name);
		validateDepartment(department);
		Employee employee=new Employee(name,department);
		dao.add(employee);
		return employee;
	}

	@Override
	public Employee findById(int id) {
		validateId(id);
		isIdPresent(id);
		Employee employee=dao.findById(id);
		return employee;
	}

	@Override
	public void removeById(int id) {
		validateId(id);
		isIdPresent(id);
		dao.removeById(id);
		
	}

	@Override
	public List<Employee> findAll() {
		List<Employee>list=dao.findAll();
		return list;
	}
	public void validateId(int id) {
		if(id<0)
		{
			throw new InvalidEmployeeIdException("Id should not be negative");
		}
	}
	void isIdPresent(int id) {
		if(!store.containsKey(id))
		{
			throw new EmployeeNotFoundException("No Employee with this id , Create new Employee with this ID");
		}
	}
	void validateName(String name){
		if(name==null || name.isEmpty() || name.trim().isEmpty()){
			throw new EmployeeNameException("Name can't be null or empty");
		}
	}
	void validateDepartment(String department){
		if(department==null || department.isEmpty() || department.trim().isEmpty()){
			throw new EmployeeDepartmentException("Department can't be null or empty");
		}
	}


}
