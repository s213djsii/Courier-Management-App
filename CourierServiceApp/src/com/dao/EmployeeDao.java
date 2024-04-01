package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import com.exception.InvalidLocationIdException;
import com.model.Employee;
import com.util.DBUtil;

public class EmployeeDao {

	public int addCourierStaff(Employee emp) throws SQLException, InvalidLocationIdException {
		Connection conn = DBUtil.getDBConn();
		
		String query="select location_id from location where location_id=?";
		PreparedStatement pstmt1 = conn.prepareStatement(query);
		//Location loc=new Location();
		pstmt1.setInt(1,emp.getLocationId());
		ResultSet idSet= pstmt1.executeQuery();	
		if(!idSet.next())
			throw new InvalidLocationIdException("invalid location id");
		String sql="insert into employee(name,email,contact_no,role,salary,location_location_id) values (?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		String name=emp.getName();
		String email=emp.getEmail();
		String phNo=emp.getContactNo();
		String role=emp.getRole();
		double salary=emp.getSalary();
		int locId=emp.getLocationId();
		
		pstmt.setString(1,name );
		pstmt.setString(2,email );
		pstmt.setString(3,phNo);
		pstmt.setString(4,role);
		pstmt.setDouble(5,salary);
		pstmt.setInt(6,locId);
		int c=pstmt.executeUpdate();
		DBUtil.dbClose();
		return c;
		
	}

	public List<Employee> getAllEmployees() throws SQLException {
		List<Employee> list=new ArrayList<>();
		Connection conn=DBUtil.getDBConn();
		String sql="select * from employee";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		
		while(rst.next()) {
			int id=rst.getInt("emp_id");
			String name=rst.getString("name");
			String email=rst.getString("email");
			String phNo=rst.getString("contact_no");
			String role=rst.getString("role");
			double salary=rst.getDouble("salary");
			int locationId=rst.getInt("location_location_id");
			Employee emp=new Employee(id,name,email,phNo,role,salary,locationId);
			list.add(emp);
			}
		DBUtil.dbClose();
		return list;
	}

	public int deleteEmployee(int id) throws SQLException {
        Connection conn = DBUtil.getDBConn();
		
		String sql="delete from employee where emp_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		int delete=pstmt.executeUpdate();
		DBUtil.dbClose();
		return delete;
	}

	

}
