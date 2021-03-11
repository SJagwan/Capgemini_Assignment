package com.cg.management.departmentmg.deptDao;


import java.util.List;

import com.cg.management.departmentmg.deptBean.Department;


public interface IDeptDao {
	
    public void addDept(Department dept);
    
    public  Department findById(int id);
	
	public void update(Department dept);
	
	public List<Department> fetchAll();
	
	

}
