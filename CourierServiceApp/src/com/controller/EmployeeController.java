package com.controller;

import java.sql.SQLException;

import java.util.List;
import java.util.Scanner;

import com.exception.InvalidLocationIdException;
import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeController {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeService employeeService=new EmployeeService();
		while(true)
		{
			System.out.println("press 1: To insert new employee details");
			System.out.println("Press 2. To display all employee details");
			System.out.println("press 3.To Delete an Employee");
			System.out.println("press 0: To exit");
			int in=sc.nextInt();
			if(in==0)
			{
				System.out.println("Thank You! exiting....");
				break;
			}
			switch(in) {
			case 1:
				System.out.println("New Staff Entry");
				System.out.println("Enter staff name:");
				String name=sc.next();
				sc.nextLine();
				System.out.println("Enter staff email:");
				String email=sc.next();
				System.out.println("Enter contact no:");
				String phNo=sc.next();
				System.out.println("Enter role of the staff:");
				String role=sc.next();
				sc.nextLine();
				System.out.println("Enter salary:");
				double salary=sc.nextDouble();
				System.out.println("Enter location id:");
				int locationId=sc.nextInt();
				Employee emp=new Employee(name,email,phNo,role,salary,locationId);
				try {
					employeeService.addCourierStaff(emp);
					System.out.println("inserted successfully");
				} catch (SQLException | InvalidLocationIdException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Employee details");
				List<Employee> list;
				try {
					list = employeeService.getAllEmployees();
					for(Employee e:list)
					{
						System.out.println(e);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println(e1.getMessage());
					//e1.printStackTrace();
				}
				
				break;
			case 3:
				System.out.println("Deleting an Employee Details");
				System.out.println("Enter id:");
				int id=sc.nextInt();
				try {
					employeeService.deleteEmployee(id);
					System.out.println("deleted rows successfully");
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
				
				break;
			default:
				System.out.println("Invalid Entry");
		}
		
		
		}
		sc.close();

	}

}
