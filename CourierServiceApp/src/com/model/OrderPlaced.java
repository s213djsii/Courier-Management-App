package com.model;

public class OrderPlaced {
	private int id;
	private int userId;
	private int courierId;
	public OrderPlaced() {
		super();
		// TODO Auto-generated constructor stub
	}
	public OrderPlaced(int id, int userId, int courierId) {
		super();
		this.id = id;
		this.userId = userId;
		this.courierId = courierId;
	}
	public OrderPlaced(int userId, int courierId) {
		super();
		this.userId = userId;
		this.courierId = courierId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCourierId() {
		return courierId;
	}
	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}
	@Override
	public String toString() {
		return "OrderPlaced [id=" + id + ", userId=" + userId + ", courierId=" + courierId + "]";
	}

}
