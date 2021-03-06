package com.cg.management;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


import com.cg.management.employeesmg.main.MainEmp;

@SpringBootApplication
public class EmployeeApplication {

	public static void main(String[] args) {
		 ConfigurableApplicationContext context=SpringApplication.run(EmployeeApplication.class, args);		
         MainEmp mainEmp=context.getBean( MainEmp.class);
         mainEmp.start();
	}

}
