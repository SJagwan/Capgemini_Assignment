package com.cg.management.employeesmg.employeeDao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.management.employeesmg.CustomException.EmployeeNotFoundException;
import com.cg.management.employeesmg.employeeBean.*;

@Repository
public class EmployeeDao implements IEmployeeDao{
	
	
    @PersistenceContext
    private EntityManager em;

	@Override
	public void add(Employee e) {
		em.persist(e);	
	}
	
	@Override
	public Employee findById(int id) {
		Employee e=em.find(Employee.class, id);
		if(e==null)
		{
			throw new EmployeeNotFoundException("Employee of this ID is not present");
		}
		return e;
	}
	
	@Override
	public void removeEmployee(int id) {
		 Employee e=findById(id);
		 em.remove(e);
	}
	
	@Override
	public void update(Employee e)
	{
		em.merge(e);
	}


	@Override
	public List<Employee> fetchAll() {
		String ql="from Employee";
		TypedQuery<Employee>tq=em.createQuery(ql,Employee.class);
		List<Employee>e=tq.getResultList();
		return e;
		
		
	}
	

}
