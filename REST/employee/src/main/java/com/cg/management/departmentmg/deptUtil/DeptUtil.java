package com.cg.management.departmentmg.deptUtil;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.management.departmentmg.deptBean.Department;
import com.cg.management.departmentmg.dto.DepartmentDetails;

@Component
public class DeptUtil {
	
	public DepartmentDetails toDeptDetail(Department dept)
	{
		DepartmentDetails d= new DepartmentDetails();
		d.setDeptid(dept.getDeptID());
		d.setDeptname(dept.getDeptName());
		return d;
	}
	
	public List<DepartmentDetails> toDeptDetailList(List<Department>dept)
	{
		List<DepartmentDetails> listd=new ArrayList<>();
		for(Department d:dept)
		{
			DepartmentDetails dd= new DepartmentDetails();
			dd.setDeptid(d.getDeptID());
			dd.setDeptname(d.getDeptName());
			listd.add(dd);
		}
		
		return listd;
	}

}
