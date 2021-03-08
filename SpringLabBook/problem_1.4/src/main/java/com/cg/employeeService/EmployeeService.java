package com.cg.employeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.employeeBean.Employee;
import com.cg.employeeDao.EmployeeDao;

@Component
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	public EmployeeDao dao;

	@Override
	public void add(String name, double salary) {
		Employee e=new Employee(name,salary);
		dao.add(e);
	}

	@Override
	public List<Employee> displayAll() {
	  
		return dao.displayAll();
	}
	

}
