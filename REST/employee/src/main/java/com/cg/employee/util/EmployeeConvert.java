package com.cg.employee.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.employee.dto.EmployeeDetails;
import com.cg.employee.employeeBean.Employee;

@Component
public class EmployeeConvert {
	
	public EmployeeDetails toDetail(Employee employee)
	{
		EmployeeDetails detail=new EmployeeDetails(employee.getEmpId(),employee.getEmpName(),employee.getSalary());
		return detail;
	}
	
	public List<EmployeeDetails> toDetailList(List<Employee>l){
		List<EmployeeDetails>detail=new ArrayList<>();
		for(Employee employee:l)
		{
			detail.add(toDetail(employee));
		}
		return detail;
	}

}
