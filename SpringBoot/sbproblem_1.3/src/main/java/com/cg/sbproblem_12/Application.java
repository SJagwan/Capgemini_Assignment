package com.cg.sbproblem_12;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;




@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		
		Employee e1=context.getBean(Employee.class);
		e1.setEmpId(1);
		e1.setEmpName("Shubhanshu Jagwan");
		e1.setSalary(100000);
		
		Employee e2=context.getBean(Employee.class);
		e2.setEmpId(2);
		e2.setEmpName("O4ASJ");
		e2.setSalary(600000);
		
		SBU sbu=context.getBean(SBU.class);
		List<Employee>l=new ArrayList<>();
		l.add(e1);
		l.add(e2);
		sbu.setEmpList(l);

		System.out.println(sbu);
		System.out.println("-------------------------------");
		for(Employee e :l)
		{
			System.out.println(e);
		}
		
		
		
		context.close();
		
	}

}
