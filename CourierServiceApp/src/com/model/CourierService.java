package com.model;

import java.sql.SQLException;
import java.time.LocalDate;

import com.dao.CourierDao;

public class CourierService {
	private int id;
	private String name;
	private double cost;
	public CourierService() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourierService(int id, String name, double cost) {
		super();
		this.id = id;
		this.name = name;
		this.cost = cost;
	}
	public CourierService(String name, double cost) {
		super();
		this.name = name;
		this.cost = cost;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	@Override
	public String toString() {
		return "CourierService [id=" + id + ", name=" + name + ", cost=" + cost + "]";
	}
	
	
	

}
