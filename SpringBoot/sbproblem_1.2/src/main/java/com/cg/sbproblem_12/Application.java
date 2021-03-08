package com.cg.sbproblem_12;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		
		Employee employee=context.getBean(Employee.class);
		System.out.println("Employee details");
		System.out.print("-------------------------------");
		System.out.println();
		System.out.println(employee);
		System.out.println(employee.getSbuDetail());
		
		
		context.close();
		
	}

}
