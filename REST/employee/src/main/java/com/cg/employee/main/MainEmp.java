package com.cg.employee.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.employee.employeeBean.Employee;
import com.cg.employee.employeeService.EmployeeService;

@Component
public class MainEmp {
	
	@Autowired
	EmployeeService employeeService;
	
	public void start() {
		employeeService.add("Shubhanshu jagwan",100000);
		employeeService.add("O4ASJ",600000);
		employeeService.add("Ghost",35000); 
		
		List<Employee>list=employeeService.displayAll();
		for(Employee e:list)
		{
			System.out.println(e);
		
	   }
		
	}

}
