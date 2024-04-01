package com.model;

import java.util.Objects;

public class Employee {
	@Override
	public int hashCode() {
		return Objects.hash(contactNo, email, id, locationId, name, role, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(contactNo, other.contactNo) && Objects.equals(email, other.email) && id == other.id
				&& locationId == other.locationId && Objects.equals(name, other.name)
				&& Objects.equals(role, other.role)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	private int id;
	private String name;
	private String email;
	private String contactNo;
	private String role;
	private double salary;
	private int locationId;
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(int id, String name, String email, String contactNo, String role, double salary, int locationId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.role = role;
		this.salary = salary;
		this.locationId = locationId;
	}
	public Employee(String name, String email, String contactNo, String role, double salary, int locationId) {
		super();
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.role = role;
		this.salary = salary;
		this.locationId = locationId;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", email=" + email + ", contactNo=" + contactNo + ", role="
				+ role + ", salary=" + salary + ", locationId=" + locationId + "]";
	}

}
