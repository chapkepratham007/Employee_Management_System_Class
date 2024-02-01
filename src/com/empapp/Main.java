package com.empapp;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EmployeeDaoInterface dao=new EmployeeDaoImplement();
		System.out.println("***Welcome to Employee Management Application***\n\n");
		Scanner sc=new Scanner(System.in);
		do {
			System.out.println("\nEnter your choice: ");
			System.out.println("1.Add Employess\n"+
			"2.Show All Employees\n"+
			"3.Show employees based on id\n"+
			"4.Update the employees\n"+
			"5.Delete the Employees\n"+
			"6.Exit from App");
			int ch=sc.nextInt();
			switch(ch) {
			case 1:
				Employee emp=new Employee();
				System.out.println("Enter id: ");
				int id=sc.nextInt();
				System.out.println("Enter name: ");
				String name =sc.next();
				System.out.println("Enter Salary: ");
                double salary = 0.0;
                try {
                    salary = sc.nextDouble();
                } catch (java.util.InputMismatchException e) {
                    System.out.println("Invalid input format. Please enter a valid number for the salary.");
                    sc.nextLine(); // clear the scanner buffer
                    continue; // continue to the next iteration of the loop
                }
				
				System.out.println("Enter age: ");
				int age=sc.nextInt();
				emp.setId(id);
				emp.setName(name);
				emp.setSalary(salary);
				emp.setAge(age);
				dao.createEmployee(emp);
				break;
			case 2:
				dao.showAllEmployee();
				break;
			case 3:
				System.out.println("Enter id to show the details of the employee: ");
				int empid=sc.nextInt();
				dao.showEmployeeBasedOnId(empid);
				break;
			case 4:
				System.out.println("Enter id to update the details of the employees: ");
				int empid1=sc.nextInt();
				System.out.println("Enter the new name of the employee");
				String name1 =sc.next();
				dao.updateEmployee(empid1, name1);
				break;
			case 5:
				System.out.println("Enter id to delete the details of the employee: ");
				int id1=sc.nextInt();
				dao.deleteEmployee(id1);
				break;
			case 6:
				System.out.println("Thank you to use the App...");
				System.exit(0);
			default:
				System.out.println("Enter valid choice");
			}
		}while(true);
	}

}
