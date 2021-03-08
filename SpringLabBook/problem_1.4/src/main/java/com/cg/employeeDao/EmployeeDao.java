package com.cg.employeeDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.cg.employeeBean.Employee;

@Component
public class EmployeeDao implements IEmployeeDao{
	static int i=0;
	public int generateId() {
		return ++i;
	}
	
    Map<Integer,Employee>store=EStore.store;

	@Override
	public void add(Employee e) {
		int newID=generateId();
		e.setEmpId(newID);
		store.put(newID, e);	
	}

	@Override
	public List<Employee> displayAll() {
		Collection<Employee>ce=store.values();
		List<Employee>e=new ArrayList<>(ce);
		return e;
		
		
	}
	

}
