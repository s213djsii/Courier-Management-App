package com.model;

public class User {
	private int userId;
	private String name;
	private String email;
	private String password;
	private String contactNo;
	private String address;
	public User() {
		
	}
	public User(String name, String email, String password, String contactNo, String address) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.address = address;
	}
	public User(int userId, String name, String email, String password, String contactNo, String address) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.contactNo = contactNo;
		this.address = address;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", contactNo=" + contactNo + ", address=" + address + "]";
	}
	
	
	
}
