package com.empmgt.ui;

import com.empmgt.entities.*;
import com.empmgt.exceptions.*;
import java.util.*;

public class EmployeeMain {
	private Map<Integer, Employee> stores = new HashMap<>();

	public static void main(String[] args) {
		EmployeeMain project = new EmployeeMain();
		project.run();
	}

	private void run() {
		try {
			Department department1 = new Department("D1", "Development");
			Department department2 = new Department("T1", "Testing");
			Department department3 = new Department("T2", "Testing");
			Department department4 = new Department("D2", "Development");

			addDeveloper(001, "Shubhanshu", department1, "Java");
			addTester(002, "Hardik", department2, "STS 4");
			addTester(004, "O4ASJ", department3, "VS Code");
			addDeveloper(003, "Dragon", department4, "Python");

			int toFindId = 003;
			Employee employee = findEmployeeById(toFindId);
			System.out.println("Found the customer with ID:" + toFindId);
//			displayCommon(employee);

			System.out.println();
			System.out.println("*****   Displaying all the Employees Before Removing    ****");
			System.out.println();

			displayAll();
			System.out.println();

			int idToRemove = 002;
			removeEmployeeById(idToRemove);

			System.out.println("****   Displaying all the Employees  ******");
			System.out.println();

			displayAll();

		} catch (InvalidCustomerId e) {
//			e.printStackTrace();
			String msg = e.getMessage();
			System.out.println(msg);
		} catch (EmployeeNotFound e) {
//			e.printStackTrace();
			String msg = e.getMessage();
			System.out.println(msg);
		} catch (Exception e) {
			System.out.println("Some error , plz fill the detail about the error");
		}

	}

	public void addDeveloper(int id, String name, Department department, String language) {
		Developer employee = new Developer(id, name, department, language);
		stores.put(id, employee);
	}

	public void addTester(int id, String name, Department department, String tools) {
		Developer employee = new Developer(id, name, department, tools);
		stores.put(id, employee);
	}

	public Employee findEmployeeById(int id) {
		isIdValid(id);
		if (stores.containsKey(id)) {
			return stores.get(id);
		}
		throw new EmployeeNotFound("No employee with this id");
	}

	public void removeEmployeeById(int id) {
		isIdValid(id);
		stores.remove(id);
	}

	public void isIdValid(int id) {
		if (id < 0) {
			throw new InvalidCustomerId("Please enter correct ID(+ve)");
		}
	}

	public void displayAll() {

		Collection<Employee> employees = stores.values();

		for (Employee e : employees) {
			if (e instanceof Developer) {
				Developer employee = (Developer) e;
				displayDetails(employee);
			} else {
				Tester employee = (Tester) e;
				displayDetails(employee);
			}

		}

	}

	public void displayCommon(Employee employee) {
		System.out.print(employee); // it will run employee.toString();

	}

	public void displayDetails(Developer employee) {
		displayCommon(employee);
		System.out.println("  LanguageUsed: " + employee.getLanguage());
	}

	public void displayDetails(Tester employee) {
		displayCommon(employee);
		System.out.println("  ToolsUsed: " + employee.getTools());
	}

}
