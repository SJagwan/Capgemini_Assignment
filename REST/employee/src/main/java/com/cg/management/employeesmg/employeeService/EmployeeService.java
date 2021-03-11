package com.cg.management.employeesmg.employeeService;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.cg.management.employeesmg.CustomException.InvalidEmployeeIdException;
import com.cg.management.employeesmg.CustomException.InvalidEmployeeNameException;
import com.cg.management.employeesmg.employeeBean.Employee;
import com.cg.management.employeesmg.employeeDao.EmployeeDao;

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	public EmployeeDao dao;

	@Transactional
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
	
	@Transactional
	@Override
	public void removeEmployee(int id) {
		validateID(id);
		dao.removeEmployee(id);
	}
	
	@Transactional
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
