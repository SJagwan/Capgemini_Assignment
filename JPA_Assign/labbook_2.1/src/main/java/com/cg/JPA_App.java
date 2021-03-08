package com.cg;

import java.util.*;

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
		
		Author a1=new Author("Shubhanshu",null);
		em.persist(a1);
		Book b1=new Book("Alchemist",180);
		Book b2=new Book("RichDadpoordad",360);
		em.persist(b1);
		em.persist(b2);
		Set<Book>book1=new HashSet<>();
		book1.add(b1);
		book1.add(b2);
		a1.setBooks(book1);
		em.merge(a1);
		
		Author a2=new Author("Hardik",null);
		em.persist(a2);
		Book b3=new Book("Ghost",720);
		Book b4=new Book("Hindi",360);
		em.persist(b3);
		em.persist(b4);
	
		Set<Book>book2=new HashSet<>();
		book2.add(b3);
		book2.add(b4);
		a2.setBooks(book2);
		em.merge(a2);
		System.out.println("Done");
		
		et.commit();
		
		em.close();
	}

}
