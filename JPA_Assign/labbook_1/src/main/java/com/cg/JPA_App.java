package com.cg;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPA_App {

	public static void main(String[] args) {
		JPA_App app=new JPA_App();
		app.start();
	}
	void start() {
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("training-ms");
		EntityManager em=emf.createEntityManager();
		EntityTransaction et=em.getTransaction();
		et.begin();
		
		Author a1=new Author("Shubhanshu","Singh","Jagwan",121);
		Author a2=new Author("Hardik","Singh","Jagwan",101);
		Author a3=new Author("Death","O4ASJ","Ghost",111);
		
		em.persist(a1);
		em.persist(a2);
		em.persist(a3);
		
		
		Author a=em.find(Author.class,1);
		System.out.print(a);
		
		et.commit();
		em.close();
	}

}
