package com.service;

import java.sql.SQLException;

import java.util.List;

import com.dao.EmployeeDao;
import com.exception.InvalidLocationIdException;
import com.model.Employee;

public class EmployeeService {
	EmployeeDao empDao=new EmployeeDao();

	public int addCourierStaff(Employee emp) throws SQLException, InvalidLocationIdException {
		
		return empDao.addCourierStaff(emp);
		
	}

	public List<Employee> getAllEmployees() throws SQLException {
		// TODO Auto-generated method stub
		return empDao.getAllEmployees() ;
	}

	public int deleteEmployee(int id) throws SQLException {
		return empDao.deleteEmployee(id);
		
	}

	

	

}
