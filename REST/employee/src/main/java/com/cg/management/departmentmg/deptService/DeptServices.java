package com.cg.management.departmentmg.deptService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.management.departmentmg.deptBean.Department;
import com.cg.management.departmentmg.deptDao.DeptDao;
import com.cg.management.departmentmg.deptException.InvalidDepartmentNameException;

import com.cg.management.employeesmg.employeeBean.Employee;
import com.cg.management.employeesmg.employeeDao.EmployeeDao;

@Service
public class DeptServices implements IDeptServices {
	
	@Autowired
	private DeptDao dao;
	
	@Autowired
	private EmployeeDao employeeDao;

    @Transactional
	@Override
	public void addDepartment(String name) {
		validateName(name);
		Department d=new Department();
		d.setDeptName(name);
		dao.addDept(d);
		
	}
    
    
    @Transactional
	@Override
	public void addEmployeeToDept(int DeptId, int EmpId) {
		Department d=findById(DeptId);
		Set<Employee>employees=d.getEmployees();
		if(employees == null)
		{
			employees=new HashSet<>();
			d.setEmployees(employees);
		}
		Employee e=employeeDao.findById(EmpId);
		employees.add(e);
		e.setDepartment(d);
		employeeDao.update(e);	
	}

    @Transactional
	@Override
	public void removeEmployeefromDept(int DeptId, int EmpId) {
		Department d=findById(DeptId);
		Set<Employee>employees=d.getEmployees();
		if(employees != null)
		{
			Employee e=employeeDao.findById(EmpId);
			employees.remove(e);
			e.setDepartment(null);
			employeeDao.update(e);
		}
		
		
		
	}

	@Override
	public Department findById(int id) {
		return dao.findById(id);
		
	}
	
	@Override
	public List<Department> fetchAll() {
	  
		return dao.fetchAll();
	}
	
	public void validateName(String name)
	{
		if(name == null || name.isEmpty() || name.trim().isEmpty())
		{
			throw new InvalidDepartmentNameException("Plz enter a name");
		}
	}
	

}
