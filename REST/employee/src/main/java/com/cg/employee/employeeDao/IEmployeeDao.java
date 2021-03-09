package com.cg.employee.employeeDao;
import java.util.List;

import com.cg.employee.employeeBean.Employee;

public interface IEmployeeDao {
	
	public void add(Employee e);
	
	public List<Employee> displayAll();

}
