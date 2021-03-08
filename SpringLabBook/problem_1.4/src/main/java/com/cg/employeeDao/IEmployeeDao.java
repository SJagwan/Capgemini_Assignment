package com.cg.employeeDao;
import java.util.List;

import com.cg.employeeBean.*;

public interface IEmployeeDao {
	
	public void add(Employee e);
	
	public List<Employee> displayAll();

}
