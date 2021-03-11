package com.cg.management.employeesmg.employeeBean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.cg.management.departmentmg.deptBean.Department;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private int empId;

	private String empName;

	private double salary;
	
	@ManyToOne
	private Department department;
	
	public Employee() {
		
	}

	public Employee(String empName, double salary) {
		this.empName = empName;
		this.salary = salary;
	}
	
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
	
	
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", salary=" + salary + "]";
	}


}