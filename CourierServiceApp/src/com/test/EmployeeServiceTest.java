package com.test;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import com.exception.InvalidLocationIdException;
import com.model.Employee;
import com.service.EmployeeService;

public class EmployeeServiceTest {
	@Test
	public void insertOfficerTest()  {
		EmployeeService employeeService=new EmployeeService();
		Employee employee=new Employee("janani","janu@gmail.com","7845963215","manager",45000,5);
		/*  usecase1 */
		try {
			Assert.assertEquals(1, employeeService.addCourierStaff(employee));
		} catch (SQLException | InvalidLocationIdException  e) { }
		employee=new Employee("tina","tina@gmail.com","7845223215","cover man",23000,7);
		//use case 2
		try {
			Assert.assertEquals(1, employeeService.addCourierStaff(employee));
		} catch (SQLException | InvalidLocationIdException  e) { }
	}
	@Test
	public void deleteEmployeeTest() {
		
		EmployeeService employeeService=new EmployeeService();
		
		/* deleting officer usecase1 */
		try {
			Assert.assertEquals(0, employeeService.deleteEmployee(1));
		} catch ( SQLException e) {
			
		}
		
		
	}

}
