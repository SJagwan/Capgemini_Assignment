package com.cg.employee.employeeDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Repository;

import com.cg.employee.CustomException.EmployeeNotFoundException;
import com.cg.employee.employeeBean.*;

@Repository
public class EmployeeDao implements IEmployeeDao{
	static int i=0;
	public int generateId() {
		return ++i;
	}
	
    private Map<Integer,Employee>store=EStore.store;

	@Override
	public void add(Employee e) {
		int newID=generateId();
		e.setEmpId(newID);
		store.put(newID, e);	
	}
	
	@Override
	public Employee findById(int id) {
		if(!store.containsKey(id)) {
			throw new EmployeeNotFoundException("Employee of this ID is not present");
		}
		return store.get(id);
	}
	
	@Override
	public Employee removeEmployee(int id) {
		if(!store.containsKey(id)) {
			throw new EmployeeNotFoundException("Employee of this ID is not present, So cannot be removed");
		}
		return store.remove(id);
	}
	
	@Override
	public void update(Employee e)
	{
		store.put(e.getEmpId(), e);
	}


	@Override
	public List<Employee> fetchAll() {
		Collection<Employee>ce=store.values();
		List<Employee>e=new ArrayList<>(ce);
		return e;
		
		
	}
	

}
