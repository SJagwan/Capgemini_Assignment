package com.cg.management.departmentmg.deptBean;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.cg.management.employeesmg.employeeBean.Employee;

@Entity
public class Department {
	
	@GeneratedValue
	@Id
	private int deptID;
	private String deptName;
	
	@OneToMany(mappedBy="department")
	private Set<Employee>employees;
	
	public Department() {
	}

	public Department(int deptID, String deptName) {
		this.deptID = deptID;
		this.deptName = deptName;
	}

	public int getDeptID() {
		return deptID;
	}

	public void setDeptID(int deptID) {
		this.deptID = deptID;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [deptID=" + deptID + ", deptName=" + deptName + "]";
	}
	
	

}
