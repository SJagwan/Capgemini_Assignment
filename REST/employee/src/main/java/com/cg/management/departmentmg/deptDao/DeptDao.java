package com.cg.management.departmentmg.deptDao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.cg.management.departmentmg.deptBean.Department;

@Repository
public class DeptDao implements IDeptDao {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void addDept(Department dept) {
		em.persist(dept);	
		
	}

	@Override
	public Department findById(int id) {
		return em.find(Department.class,id);
	}

	@Override
	public void update(Department dept) {
		em.merge(dept);
		
	}
	@Override
	public List<Department> fetchAll() {
		String ql="from Department";
		TypedQuery<Department>tq=em.createQuery(ql,Department.class);
		List<Department>e=tq.getResultList();
		return e;
		
		
	}
	
	
	

}
