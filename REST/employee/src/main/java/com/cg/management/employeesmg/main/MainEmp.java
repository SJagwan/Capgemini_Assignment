package com.cg.management.employeesmg.main;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.management.employeesmg.CustomException.EmployeeNotFoundException;
import com.cg.management.employeesmg.CustomException.InvalidEmployeeIdException;
import com.cg.management.employeesmg.CustomException.InvalidEmployeeNameException;
import com.cg.management.employeesmg.employeeBean.Employee;
import com.cg.management.employeesmg.employeeService.EmployeeService;

@Component
public class MainEmp {
	
	@Autowired
	EmployeeService employeeService;
	
	public void start() {
		try {
			employeeService.add("Shubhanshu jagwan",100000);
			employeeService.add("O4ASJ",600000);
			employeeService.add("Ghost",35000); 
			
			display(employeeService.findById(1));
			
			
			displayAll(employeeService.fetchAll());
			
			
		}catch(InvalidEmployeeNameException e) {
			System.out.print(e.getMessage());	
		}catch(InvalidEmployeeIdException e) {
			System.out.print(e.getMessage());
		}catch(EmployeeNotFoundException e) {
			System.out.print(e.getMessage());
		}	catch(Exception e) {
			System.out.print(e.getMessage());
		}
				
	}
	public void display(Employee e) {
		System.out.println("---------------------Employee Found/Remove----------------");
		System.out.println(e);
		System.out.println();
	}
	public void displayAll(List<Employee>list)
	{
		System.out.println("---------------------Display All Employee----------------");
		for(Employee e:list)
		{
			System.out.println(e);
		
	   }	
	}
	

}
