package com.service;

import java.sql.SQLException;

import java.util.List;

import com.dao.CourierDao;
import com.dto.AssignedOrderDto;
import com.dto.CourierStatusDto;
import com.exception.InvalidCourierIdException;
import com.exception.InvalidEmployeeIdException;
import com.exception.TrackingNumberNotFoundException;
import com.model.Courier;

public class CourierServiceApp {
	CourierDao courierDao=new CourierDao();

	

	public CourierStatusDto getOrderStatus(int id) throws SQLException, InvalidCourierIdException {
		// TODO Auto-generated method stub
		return courierDao.getOrderStatus(id);
	}
	
	
	public int deleteOrder(int id) throws SQLException, InvalidCourierIdException {
		// TODO Auto-generated method stub
		
		return courierDao.deleteOrder(id);
	}

	public int placeOrder(Courier courier) throws SQLException {
		return courierDao.placeOrder(courier);
		
	}


	public List<AssignedOrderDto> assignedOrder(int empId) throws SQLException, InvalidEmployeeIdException {
		
		return courierDao.assignedOrder(empId);
	}


	public void trackNo(int in) throws TrackingNumberNotFoundException {
		if(in<=0)
		{
			throw new TrackingNumberNotFoundException("Invalid Tracking No");
		}
		else
		{
			System.out.println("The given tracking number is valid");
		}
		
	}



	public CourierStatusDto getOrderStatus1(List<CourierStatusDto> list, int id) throws InvalidCourierIdException {
		for(CourierStatusDto e : list) {
			if(e.getId() == id)
				//System.out.println(e);
				return e; 
		}
		throw new InvalidCourierIdException("Courier ID does not exist");
	}


	public AssignedOrderDto getOrderOfEmployee(List<AssignedOrderDto> list, int id) throws InvalidEmployeeIdException {
		for(AssignedOrderDto e : list) {
			if(e.getCourierId() == id)
				//System.out.println(e);
				return e; 
		}
		throw new InvalidEmployeeIdException("employee does not have any order");
	}


	public void UpdateOrderStatus(int courierId, String status1) throws SQLException {
		courierDao.UpdateOrderStatus(courierId,status1);
		
	}


	
	
	


	

	

}
