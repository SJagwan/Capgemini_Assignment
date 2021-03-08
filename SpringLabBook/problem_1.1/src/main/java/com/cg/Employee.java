package com.cg;


import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value("${employee.id}")
	int empId;
	
	@Value("${employee.name}")
	String empName;
	
	@Value("${employee.salary}")
	double salary;
	
	@Value("${employee.unit}")
	String businessUnit;
	
	
	

	@Value("${employee.age}")
	int age;

	
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getBusinessUnit() {
		return businessUnit;
	}
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", businessUnit="
				+ businessUnit + ", age=" + age + "]";
	}


}