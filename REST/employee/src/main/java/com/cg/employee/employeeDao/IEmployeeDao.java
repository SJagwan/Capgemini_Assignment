package com.cg.employee.employeeDao;
import java.util.List;

import com.cg.employee.employeeBean.Employee;

public interface IEmployeeDao {
	
	public void add(Employee e);
	
	public Employee findById(int id);
	
	public Employee removeEmployee(int id);
	
	public void update(Employee e);
	
	public List<Employee> fetchAll();

}
