package com.test;

import java.sql.SQLException;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.dto.AssignedOrderDto;
import com.dto.CourierStatusDto;
import com.enums.CourierStatus;
import com.exception.InvalidCourierIdException;
import com.exception.InvalidEmployeeIdException;
import com.model.Courier;
import com.service.CourierServiceApp;

public class CourierServiceTest {
	@Test
	public void insertCourierTest() {
		CourierServiceApp courierService=new CourierServiceApp();
		Courier courier=new Courier("abhi","coimbatore","vikram","chennai",4.5,CourierStatus.YETTOTRANSIT,new Random().nextInt(1000),LocalDate.parse("2024-03-21"));
		/* insertion success usecase1 */
		try {
			Assert.assertEquals(1, courierService.placeOrder(courier));
		} catch (SQLException  e) { }
		courier=new Courier("kalyan","chennai","prasad","bangalore",5,CourierStatus.YETTOTRANSIT,new Random().nextInt(1000),LocalDate.parse("2024-02-11"));
		/* insertion success usecase2 */
		try {
			Assert.assertEquals(1, courierService.placeOrder(courier));
		} catch (SQLException  e) { }
	}
	@Test
	public void deleteOrderTest() {
		
		CourierServiceApp courierService=new CourierServiceApp();
		
		/* deleting officer usecase1 */
		try {
			Assert.assertEquals(0, courierService.deleteOrder(2));
		} catch ( SQLException | InvalidCourierIdException e) {
			
		}
		/* deleting officer usecase2 */
		try {
			Assert.assertEquals(1, courierService.deleteOrder(15));
		} catch ( SQLException | InvalidCourierIdException e) {
			
		}
		
	}
	@Test
	public void getOrderStatusTest() {
		/* Use Case 1: Valid ID */
		CourierServiceApp courierService=new CourierServiceApp();
		CourierStatusDto s1 = new CourierStatusDto(1,CourierStatus.YETTOTRANSIT);
		CourierStatusDto s2 = new CourierStatusDto(2,CourierStatus.DELIVERED);
		CourierStatusDto s3 = new CourierStatusDto(3,CourierStatus.YETTOTRANSIT);
		CourierStatusDto s4 = new CourierStatusDto(4,CourierStatus.INTRANSIT);
		
		List<CourierStatusDto> list = new ArrayList<>();
		list.add(s1);list.add(s2);list.add(s3);list.add(s4);
		int id =1; 
		CourierStatusDto exceptedOutput = new  CourierStatusDto(1,CourierStatus.YETTOTRANSIT);
		
		try {
			Assert.assertEquals(exceptedOutput,courierService.getOrderStatus1(list,id));
		} catch ( InvalidCourierIdException e) {}
		
		/* Use Case 2: Invalid ID*/
		id =50; 
		try {
			Assert.assertEquals(exceptedOutput, courierService.getOrderStatus1(list,id));
		} catch ( InvalidCourierIdException e) {
			Assert.assertEquals("Courier ID does not exist".toLowerCase(), e.getMessage().toLowerCase());
		}	
		
	}
	@Test
	public void getOrderOfEmployeeTest() {
		/* Use Case 1: Valid ID */
		CourierServiceApp courierService=new CourierServiceApp();
		AssignedOrderDto d1 = new AssignedOrderDto(4,"weasley","pune","janu","chennai","ramu");
		AssignedOrderDto d2 = new AssignedOrderDto(2,"ben","bangalore","kevin","mumbai","vikram");
		AssignedOrderDto d3 = new AssignedOrderDto(1,"stuart","chennai","drape","bangalore","jai");
		AssignedOrderDto d4 = new AssignedOrderDto(3,"chris","pune","harris","donald","prem");
		
		List<AssignedOrderDto> list = new ArrayList<>();
		list.add(d1);list.add(d2);list.add(d3);list.add(d4);
		int id =4; 
		AssignedOrderDto exceptedOutput = new  AssignedOrderDto(4,"weasley","pune","janu","chennai","ramu");
		
		try {
			Assert.assertEquals(exceptedOutput,courierService.getOrderOfEmployee(list,id));
		} catch ( InvalidEmployeeIdException e) {}
		
		/* Use Case 2: Invalid ID*/
		id =50; 
		try {
			Assert.assertEquals(exceptedOutput, courierService.getOrderOfEmployee(list,id));
		} catch (  InvalidEmployeeIdException e) {
			Assert.assertEquals("employee does not have any order".toLowerCase(), e.getMessage().toLowerCase());
		}	
		
	}

	
}
