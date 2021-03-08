package com.cg.main;

import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.cg.JavaConfig;
import com.cg.employeeBean.Employee;
import com.cg.employeeService.EmployeeService;

public class MainApplication {

	public static void main(String[] args) {
		
		MainApplication app=new MainApplication();
		app.start();
	}
	
	void start() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.register(JavaConfig.class);
		context.refresh();
		
		EmployeeService employeeService=context.getBean(EmployeeService.class);
		
		employeeService.add("Shubhanshu jagwan",100000);
		employeeService.add("O4ASJ",600000);
		employeeService.add("Ghost",35000);
		
		
		List<Employee>l=new ArrayList<>(employeeService.displayAll());
		for(Employee e:l)
		{
			System.out.println(e);
		}
		
		context.close();
		
	}

}
