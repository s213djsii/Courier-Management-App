package com.model;

import java.time.LocalDate;

public class Payment {
	private int paymentId;
	private double amount;
	private LocalDate paymentDate;
	private int courierId;
	private int locationId;
	public Payment() {
		
	}
	
	public Payment(int paymentId, double amount, LocalDate paymentDate, int courierId, int locationId) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.courierId = courierId;
		this.locationId = locationId;
	}

	public Payment(double amount, LocalDate paymentDate, int courierId, int locationId) {
		super();
		this.amount = amount;
		this.paymentDate = paymentDate;
		this.courierId = courierId;
		this.locationId = locationId;
	}
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getCourierId() {
		return courierId;
	}
	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", amount=" + amount + ", paymentDate=" + paymentDate
				+ ", courierId=" + courierId + ", locationId=" + locationId + "]";
	}

}
