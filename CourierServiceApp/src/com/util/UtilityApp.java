package com.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class UtilityApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("Press 1.Status of Tracking Number");
			System.out.println("Press 2.Calculate Shipping Cost");
			System.out.println("Press 3.To Confirm Order");
			System.out.println("Press 4.To find Similar address");
			System.out.println("Press 5.Data Validation");
			System.out.println("Press 0.To Exit");
		
		int in=sc.nextInt();
		if(in==0)
		{
			System.out.println("Exiting Thank You....");
			break;
		}
		switch(in) {
		case 1:
			String a[][]= {{"1","Parcel in Transit"},{"2","parcel delivered"},{"3","parcel out for delivery"}};
		    System.out.println("Enter tracking number:");
		    String trackingNo=sc.next();
		    int tNo=0;
		    int sNo=1;
		    int c=0;
		    for(int i=0;i<3;i++)
		    {
		    	c=0;
		    	if(a[i][tNo].equals(trackingNo))
		    	{
		    		System.out.println(a[i][sNo]);
				    c=1;
				    break;
			    }
			
		    }
		    if(c==0)
		    {
		    	System.out.println("Invalid tracking no");
		    }
		    break;
		case 2:
			System.out.println("----shipping cost-----");
			System.out.println("Enter source address:");
			String source=sc.next();
			System.out.println("Enter destination address:");
			String destination=sc.next();
			System.out.println("Enter location distance:");
			int dis=sc.nextInt();
			System.out.println("Enter parcel weight:");
			double weight=sc.nextDouble();
			shippingCost(dis,weight);
			break;
		case 3:
			System.out.println("------order confirmation-----");
			System.out.println("Enter customer name:");
			String customerName=sc.next();
			//sc.nextLine();
			System.out.println("Enter delivery address:");
			String add=sc.next();
			//sc.nextLine();
			System.out.println("Enter delivery date");
			String deliveryDate=sc.next();
			orderConfirmation(customerName,add,deliveryDate);
			break;
		case 4:
			System.out.println("-----Find similar address------ ");
			System.out.println("enter address:");
			sc.nextLine();
			String address=sc.nextLine();
			
			findSimilarAddress(address);
			break;
		case 5:
			System.out.println("--------Data Validation--------");
			System.out.println("Enter name:");
			String name=sc.next();
			System.out.println("Enter address:");
			String address1=sc.next();
			System.out.println("Enter phone no:");
			String phNo=sc.next();
			boolean validity=dataValidation(name,address1,phNo);
			if(validity) {
				System.out.println("given data is valid");
			}
			else {
				System.out.println("Invalid data");
			}
			
			break;
		default:
			System.out.println("Invalid Input");
	
		
		}
		
		}
		
		
		
		
		
		sc.close();
		
	}
	private static boolean dataValidation(String name, String address1, String phNo) {
		char c[]=name.toCharArray();
		char a[]=address1.toCharArray();
		char n[]=phNo.toCharArray();
		if(name.equals("null") || address1.equals("null") || phNo.equals("null")) {
			return false;
		
		}
		else {
			for(char ch:c)
			{
				if(!Character.isLetter(ch)) {
					return false;
				}
			}
			if(phNo.length()!=10) {
				return false;
			}
				for(char ch:n)
				{
					if(!Character.isDigit(ch))
					{
						return false;
					}
				}
			
			
			for(char ch:a)
			{
				if(!(Character.isDigit(ch) || Character.isLetter(ch)))
				{
					return false;
				}
			}
			
			
		}
		return true;
		
	}
	private static void findSimilarAddress(String address) {
		List<String> list=new ArrayList<>();
		list.add("maravenari");
		list.add("johnedward");
		list.add("richardwelsey");
		list.add("velbourne");
		list.add("gandhi road");
		boolean similarAddressFound = false;
		for (String a : list) {
			
            if (a.equalsIgnoreCase(address)) {
            	
                similarAddressFound = true;
                break;
            }
        }

        if (similarAddressFound) {
            System.out.println("similar address found.");
        }
        else {
        	System.out.println("No Similar address found");
        }
		
		
	}
	private static void orderConfirmation(String customerName,String add,String deliveryDate) {
		Random rand = new Random();
		if((customerName.equals("null"))||  (add.equals("null")) || deliveryDate.equals("null") ){
			System.out.println("order failed");
		}
		else {
			System.out.println("order has been confirmed and your order no is:"+rand.nextInt(1000));
		}
		
	}
	private static void shippingCost(int dis, double weight) {
		double totalCost=dis*weight;
		System.out.println("Total shipping Cost is"+totalCost);
		
	}
	

}
