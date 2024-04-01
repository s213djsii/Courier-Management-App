/**
 * 
 */
package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import com.dto.AssignedOrderDto;
import com.dto.CourierStatusDto;
import com.enums.CourierStatus;
import com.exception.InvalidCourierIdException;
import com.exception.InvalidEmployeeIdException;
import com.model.Courier;
import com.model.Employee;
import com.util.DBUtil;


public class CourierDao {

	

	

	public int deleteOrder(int id) throws SQLException, InvalidCourierIdException {
        Connection conn = DBUtil.getDBConn();
		
		String sql="delete from courier where courier_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		String query="select courier_id from courier where courier_id=?";
		PreparedStatement pstmt1 = conn.prepareStatement(query);
		pstmt1.setInt(1, id);
		ResultSet idSet= pstmt1.executeQuery();	
		
        
 	
		if(!(idSet.next()))
			throw new InvalidCourierIdException("invalid courier id");
		pstmt.setInt(1, id);
		int outcome=pstmt.executeUpdate();
		DBUtil.dbClose();
		return outcome;
		
		
		
	}



	public CourierStatusDto getOrderStatus(int id) throws SQLException, InvalidCourierIdException {
		Connection conn=DBUtil.getDBConn();
        String sql="select courier_id,status from courier where courier_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1,id);
		ResultSet rst=pstmt.executeQuery();
		CourierStatusDto co=new CourierStatusDto();
		if(rst.next()) {
			int id1 = rst.getInt("courier_id");
			String status=rst.getString("status").toUpperCase();
			co.setId(id1);
			co.setStatus(CourierStatus.valueOf(status));
			
		}
		else {
			 DBUtil.dbClose(); // Close the connection before throwing the exception
			    throw new InvalidCourierIdException("Courier ID does not exist");
		}
		DBUtil.dbClose();
		return co;
	}



	public int placeOrder(Courier courier) throws SQLException {
		Connection conn = DBUtil.getDBConn();
		String sql="insert into courier(sender_name,sender_address,receiver_name,receiver_address,weight,status,tracking_number,delivery_date) values (?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		String senderName=courier.getSenderName();
		String senderAddress=courier.getSenderAddress();
		String receiverName=courier.getReceiverName();
		String receiverAddress=courier.getReceiverAddress();
		double weight=courier.getWeight();
		CourierStatus status=courier.getStatus();
		int trackingNumber=courier.getTrackingNumber();
		LocalDate localDate = LocalDate.now();
		pstmt.setString(1,senderName );
		pstmt.setString(2,senderAddress );
		pstmt.setString(3,receiverName);
		pstmt.setString(4,receiverAddress);
		pstmt.setDouble(5,weight);
		pstmt.setString(6,status.toString());
		pstmt.setInt(7,trackingNumber);
		pstmt.setString(8,localDate.toString());
		int c=pstmt.executeUpdate();
		DBUtil.dbClose();
		return c;
		
	}



	public List<AssignedOrderDto> assignedOrder(int empId) throws SQLException, InvalidEmployeeIdException {
		Connection conn = DBUtil.getDBConn();
		Employee emp=new Employee();
		List<AssignedOrderDto> list=new ArrayList<>();
		String query="select emp_id from employee where emp_id=?";
		PreparedStatement pstmt1 = conn.prepareStatement(query);
		pstmt1.setInt(1,empId);
		ResultSet idSet= pstmt1.executeQuery();	
		if(!(idSet.next())) {
			throw new InvalidEmployeeIdException("employee does not have any order");
		}
		String sql="select c.courier_id,c.sender_name,c.sender_address,c.receiver_name,c.receiver_address,e.name\r\n"
				+ "from courier c,payment p,location l,employee e\r\n"
				+ "where c.courier_id=p.courier_courier_id and p.location_location_id=l.location_id and l.location_id=e.location_location_id\r\n"
				+ "and e.emp_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,empId);
		ResultSet rst=pstmt.executeQuery();
		
		while(rst.next())
		{
			AssignedOrderDto aod=new AssignedOrderDto();
			int id = rst.getInt("courier_id");
			String senderName=rst.getString("sender_name");
			String senderAddress=rst.getString("sender_address");
			String receiverName=rst.getString("receiver_name");
			String receiverAddress=rst.getString("receiver_address");
			String empName=rst.getString("name");
			aod.setCourierId(id);
			aod.setSenderName(senderName);
			aod.setSenderAddress(senderAddress);
			aod.setReceiverName(receiverName);
			aod.setReceiverAddress(receiverAddress);
			aod.setEmployeeName(empName);
			list.add(aod);
		}
		
		DBUtil.dbClose();
		return list;
		
	}



	public void UpdateOrderStatus(int courierId, String status1) throws SQLException {
        Connection conn = DBUtil.getDBConn();
		
		String sql="update courier set status=? where courier_id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,status1);
		pstmt.setInt(2,courierId);
        pstmt.executeUpdate();
		
		DBUtil.dbClose();
		
	}



	

	

	

}
