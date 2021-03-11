package com.cg.management.departmentmg.controllersDept;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.management.departmentmg.deptBean.Department;
import com.cg.management.departmentmg.deptService.IDeptServices;
import com.cg.management.departmentmg.deptUtil.DeptUtil;
import com.cg.management.departmentmg.dto.AddDepartmentRequest;
import com.cg.management.departmentmg.dto.AddEmployeeToDepartment;
import com.cg.management.departmentmg.dto.DepartmentDetails;
import com.cg.management.departmentmg.dto.RemoveEmployeeFromDepatment;

@RequestMapping("/department")
@RestController
public class DepartmentController {
	
	@Autowired
	private IDeptServices service;
	
	@Autowired
	private DeptUtil convert;
	
	@PostMapping("/add")
	public String addDepartment(@RequestBody AddDepartmentRequest dd) {
      	service.addDepartment(dd.getDeptname());
      	return "Department added with name "+dd.getDeptname();
		
	}
	
	@GetMapping("/findbyid/{id}")
	public String getDepartment(@PathVariable int id)
	{
		Department d=service.findById(id);
		DepartmentDetails dd=convert.toDeptDetail(d);
		return "Department Found with id "+dd.getDeptname();
	}
	
	@PutMapping("/employees/add")
	public String addEmployeeToDept(@RequestBody AddEmployeeToDepartment  ed) {
		service.addEmployeeToDept(ed.getDeptid(), ed.getEmpid());
		return "Employee added to department";
		
	}
	
	@DeleteMapping("/employees/remove")
	public String removeEmployeeFromDept(@RequestBody RemoveEmployeeFromDepatment  ed) {
		service.removeEmployeefromDept(ed.getDeptId(), ed.getEmpId());
		return "Employee removed to department";
		
	}
	
	@GetMapping
	public List<DepartmentDetails> displayAll(){
		List<DepartmentDetails>dlist=new ArrayList<>();
		List<Department>list=service.fetchAll();
		dlist=convert.toDeptDetailList(list);
		return dlist;
	}
	

}
