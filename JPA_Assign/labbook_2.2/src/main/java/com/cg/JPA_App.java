package com.cg;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class JPA_App {
	EntityManager em;

	public static void main(String[] args) {
		JPA_App app = new JPA_App();
		app.start();
	}

	void start() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("training-ms");
		em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

		Author a1 = new Author("Shubhanshu", null);
		em.persist(a1);
		Book b1 = new Book("Alchemist", 180);
		Book b2 = new Book("RichDadpoordad", 560);
		em.persist(b1);
		em.persist(b2);
		Set<Book> book1 = new HashSet<>();
		book1.add(b1);
		book1.add(b2);
		a1.setBooks(book1);
		em.merge(a1);

		Author a2 = new Author("Hardik", null);
		em.persist(a2);
		Book b3 = new Book("Ghost", 720);
		Book b4 = new Book("Hindi", 360);
		em.persist(b3);
		em.persist(b4);

		Set<Book> book2 = new HashSet<>();
		book2.add(b3);
		book2.add(b4);
		a2.setBooks(book2);
		em.merge(a2);
		System.out.println("Done");
		System.out.println();

		et.commit();

		displayAllBooks();
		displayBooksBetweenPrice();
		
//		displayBookByName("shubhanshu");
//		ListAuthorName(3);

		em.close();
	}

	void displayAllBooks() {
		String ql = "from Book";
		TypedQuery<Book> query = em.createQuery(ql, Book.class);
		List<Book> list = query.getResultList();
		System.out.println("----  Printing all books in database  ---");
		System.out.println();
		for (Book b : list) {
			System.out.println(b);
		}
		System.out.println();

	}

	void displayBooksBetweenPrice() {
		System.out.println("List all books with given price range. e.g. between Rs. 500 to 1000");
		System.out.println();
		String ql = "from Book where price between 500 and 1000";
		TypedQuery<Book> query = em.createQuery(ql, Book.class);
		List<Book> list = query.getResultList();
		for (Book b : list) {
			System.out.println(b);
		}
		System.out.println();

	}

//	void displayBookByName(String name) {
//		System.out.println("Query all books written by given author name");
//	 	System.out.println();
//	String ql="select authorId from Author where f= :name";
//	TypedQuery<Integer> query=em.createQuery(ql,Integer.class);
//		
//	}
//	
//	void ListAuthorName(int f) {
//		System.out.println("List the author name for given book id");
//	 	System.out.println();
//	 	String ql="from Author where f= :name";
//	 	TypedQuery<Integer> query=em.createQuery(ql,Integer.class);
//	 	System.out.print(query.getSingleResult());
//	 	List<Intger>list=query.getResultList();
//	 	for(String b:list)
//	 	{
//	 		System.out.println(b);
//	 	}
//		
//	}

}
