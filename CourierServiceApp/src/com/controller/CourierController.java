package com.controller;

import java.sql.SQLException;
import java.time.LocalDate;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.dto.AssignedOrderDto;
import com.dto.CourierStatusDto;
import com.enums.CourierStatus;
import com.exception.InvalidCourierIdException;
import com.exception.InvalidEmployeeIdException;
import com.model.Courier;
import com.service.CourierServiceApp;


public class CourierController {
	public static void main(String[] args)  {
		Scanner sc=new Scanner(System.in);
		CourierServiceApp courierService=new CourierServiceApp();
		while(true) {
		System.out.println("*********Courier ops**********");
		System.out.println("Press 1.To Place Order");
		System.out.println("Press 2.To know Status of the order");
		System.out.println("press 3.To Cancel the order");
		System.out.println("press 4.To Display orders of specific employee");
		System.out.println("press 5.To update status of order");
		System.out.println("press 0 To Exit");
		System.out.println("*******************");
		int input=sc.nextInt();
		if(input==0)
		{
			System.out.println("Exiting Thank You....");
			break;
		}
		switch(input) {
		case 1:
			
			Random rand = new Random();
			
			System.out.println("Placing order");
			System.out.println("Enter SenderName:");
			String senderName=sc.next();
			System.out.println("Enter SenderAddress:");
			String senderAddress=sc.next();
			System.out.println("Enter ReceiverName:");
			String receiverName=sc.next();
			System.out.println("Enter ReceiverAddress:");
			String receiverAddress=sc.next();
			System.out.println("Enter Weight of the courier:");
			double weight=sc.nextDouble();
			System.out.println("Enter status:");
			String status=sc.next().toUpperCase();
			CourierStatus courierStatus=CourierStatus.valueOf(status);
			int trackingNumber=rand.nextInt(1000);
			System.out.println("Enter date:");
			String dobString = sc.next();
			LocalDate dob = LocalDate.parse(dobString);
			Courier courier=new Courier(senderName,senderAddress,receiverName,receiverAddress,
					 weight,courierStatus, trackingNumber,dob);
			try {
				courierService.placeOrder(courier);
			} catch (SQLException e1) {
				System.out.println(e1.getMessage());
				
			}
			System.out.println("Order Placed Successfully");
			
				
			
			break;
		case 2:
			
			
			try {
				System.out.println("Status of the order");
				System.out.println("Enter id:");
				int id=sc.nextInt();
				CourierStatusDto status1 = courierService.getOrderStatus(id);
				System.out.println(status1);
				
			} catch (SQLException | InvalidCourierIdException e) {
				System.out.println(e.getMessage());
				//e.printStackTrace();
			}
			
			break;
		case 3:
			System.out.println("Cancellation of Order");
			System.out.println("Enter id:");
			int id=sc.nextInt();
			try {
				//check id is present
				courierService.deleteOrder(id);
				System.out.println("deleted rows successfully");
			} catch (SQLException | InvalidCourierIdException e) {
				System.out.println(e.getMessage());
				
			}
			break;
		case 4:
			System.out.println("orders taken by specific employee");
			System.out.println("Enter employee Id:");
			int empId=sc.nextInt();
			try {
				List<AssignedOrderDto> assign=courierService.assignedOrder(empId);
				for(AssignedOrderDto dao:assign) {
					System.out.println(dao);
				}
				
			} catch (SQLException | InvalidEmployeeIdException e) {
				System.out.println(e.getMessage());
			}
			
			
			break;
		case 5:
			System.out.println("Updating order status");
			System.out.println("Enter courier id:");
			int courierId=sc.nextInt();
			System.out.println("Enter status to be updated");
			String status1=sc.next().toUpperCase();
			CourierStatus courierStatus1=CourierStatus.valueOf(status1);
			try {
				courierService.UpdateOrderStatus(courierId,status1);
				System.out.println("updated successfully");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
				
			}
			break;
		default:
			System.out.println("Invalid Input");
		}
		
	}
	sc.close();

}
}