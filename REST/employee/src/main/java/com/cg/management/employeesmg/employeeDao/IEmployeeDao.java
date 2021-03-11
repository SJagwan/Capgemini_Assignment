package com.cg.management.employeesmg.employeeDao;
import java.util.List;

import com.cg.management.employeesmg.employeeBean.Employee;

public interface IEmployeeDao {
	
	public void add(Employee e);
	
	public Employee findById(int id);
	
	public void removeEmployee(int id);
	
	public void update(Employee e);
	
	public List<Employee> fetchAll();

}
