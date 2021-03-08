package com.cg.empmgt.dao;

import java.util.*;
import com.cg.empmgt.exceptions.EmployeeNotFoundException;


import com.cg.empmgt.beans.Employee;

public class EmployeeDao implements IEmployeeDao {
	
	private int newID=1;
	Map<Integer,Employee>store=EmployeeStore.store;
	
	int generateID() {
		newID++;
		return newID;
		
	}

	@Override
	public void add(Employee employee) {
		
		int id=generateID();
		employee.setId(id);
		store.put(id, employee);
	}

	@Override
	public Employee findById(int id) {
		return store.get(id);
		
	}

	@Override
	public void removeById(int id) {
		store.remove(id);	
	}

	@Override
	public List<Employee> findAll() {
		Collection<Employee> employee=store.values();
		List<Employee>list=new ArrayList<>(employee);
		return list;
	}
	

}
