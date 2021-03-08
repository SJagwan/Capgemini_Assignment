package com.cg.empmgt.ui;

import com.cg.empmgt.service.*;
import com.cg.empmgt.beans.*;
import com.cg.empmgt.exceptions.*;

import java.util.*;

public class EmployeeUI {
	
	private IEmployeeService service=new EmployeeServices();

	public static void main(String[] args) {
		EmployeeUI app=new EmployeeUI();
		app.start();
	}
	void start() {
		try {
			Employee e1=service.add("Shubhanshu", "CSE");
			display(e1);
			Employee e2=service.add("Hardik", "Commerce");
			display(e2);
			Employee e3=service.add("04ASJ", "Game");
			display(e3);
			Employee e4=service.add("Tejasvi", "Mechanical");
			display(e4);
			
//			List<Employee>employees1=service.findAll();
//			displayAll(employees1);
			
			System.out.println();
			System.out.println("Finding element by using ID- 2");
			Employee employee=service.findById(2);
			display(employee);

			System.out.println();
			System.out.println("Removing element by using ID -3");
			
			
			service.removeById(3);
			
			List<Employee>employees2=service.findAll();
			displayAll(employees2);
			
		}catch(InvalidEmployeeIdException e)
		{
			String msg=e.getMessage();
			System.out.println(msg);
		}catch(EmployeeNotFoundException e) {
			String msg=e.getMessage();
			System.out.println(msg);
		}catch(EmployeeNameException e) {
			String msg=e.getMessage();
			System.out.println(msg);
		}catch(EmployeeDepartmentException e) {
			String msg=e.getMessage();
			System.out.println(msg);
		}catch(Exception e) {
			System.out.println("Something went wrong");
		}
		
		
	}
	void display(Employee employee) {
		System.out.print("Displaying ");
		System.out.println(employee);
	}
	void displayAll(List<Employee>employees) {
		for(Employee employee:employees)
		{
			System.out.println(employee);
		}
		
	}

}
