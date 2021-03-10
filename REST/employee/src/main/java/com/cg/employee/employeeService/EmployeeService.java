package com.cg.employee.employeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.cg.employee.CustomException.InvalidEmployeeIdException;
import com.cg.employee.CustomException.InvalidEmployeeNameException;
import com.cg.employee.employeeBean.Employee;
import com.cg.employee.employeeDao.EmployeeDao;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	public EmployeeDao dao;

	@Override
	public void add(String name, double salary) {
		validateName(name);
		Employee e=new Employee(name,salary);
		dao.add(e);
	}
	
	@Override
	public Employee findById(int id){
		validateID(id);
		return dao.findById(id);
	}
	
	@Override
	public Employee removeEmployee(int id) {
		validateID(id);
		return dao.removeEmployee(id);
	}
	
	@Override
	public void updateName(int id, String name){
		validateName(name);
		Employee e=findById(id);
		e.setEmpName(name);
		dao.update(e);
	}

	@Override
	public List<Employee> fetchAll() {
	  
		return dao.fetchAll();
	}
	
	
	
	
	public void validateName(String name)
	{
		if(name == null || name.isEmpty() || name.trim().isEmpty())
		{
			throw new InvalidEmployeeNameException("Plz enter a name");
		}
	}
	
	public void validateID(int id) {
		if(id<0)
		{
			throw new InvalidEmployeeIdException("Id should be positive integer");
		}
	}

}
