package com.cg.sbproblem_12;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value("${employee.id}")
	int empId;
	
	@Value("${employee.name}")
	String empName;
	
	@Value("${employee.salary}")
	double salary;
	
	
	SBU businessUnit;
	
	

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
	
	public SBU getBusinessUnit() {
		return businessUnit;
	}
	@Autowired
	public void setBusinessUnit(SBU businessUnit) {
		this.businessUnit = businessUnit;
	}
	
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
//	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary +", age=" + age + "]";
	}

	public SBU getSbuDetail() {
		return getBusinessUnit();
		
	}


}