package com.cg.management.departmentmg.deptService;

import java.util.List;

import com.cg.management.departmentmg.deptBean.Department;


public interface IDeptServices {
	
	public void addDepartment(String name);
	
	public void addEmployeeToDept(int DeptId,int EmpId);
	
	public void removeEmployeefromDept(int DeptId,int EmpId);
	
	public Department findById(int id);
	
	public List<Department> fetchAll();
	

}
