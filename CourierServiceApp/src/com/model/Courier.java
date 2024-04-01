package com.model;

import java.time.LocalDate;

import java.util.Objects;

import com.enums.CourierStatus;

public class Courier {
	@Override
	public int hashCode() {
		return Objects.hash(SenderAddress, deliveryDate, id, receiverAddress, receiverName, senderName, status,
				trackingNumber, weight);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Courier other = (Courier) obj;
		return Objects.equals(SenderAddress, other.SenderAddress) && Objects.equals(deliveryDate, other.deliveryDate)
				&& id == other.id && Objects.equals(receiverAddress, other.receiverAddress)
				&& Objects.equals(receiverName, other.receiverName) && Objects.equals(senderName, other.senderName)
				&& status == other.status && trackingNumber == other.trackingNumber
				&& Double.doubleToLongBits(weight) == Double.doubleToLongBits(other.weight);
	}
	private int id;
	private String senderName;
	private String SenderAddress;
	private String receiverName;
	private String receiverAddress;
	private double weight;
	private CourierStatus status;
	private int trackingNumber;
	private LocalDate deliveryDate;
	public Courier(int id, String senderName, String senderAddress, String receiverName, String receiverAddress,
			double weight, CourierStatus status, int trackingNumber, LocalDate deliveryDate) {
		super();
		this.id = id;
		this.senderName = senderName;
		SenderAddress = senderAddress;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.weight = weight;
		this.status = status;
		this.trackingNumber = trackingNumber;
		this.deliveryDate = deliveryDate;
	}
	public Courier() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Courier(String senderName, String senderAddress, String receiverName, String receiverAddress, double weight,
			CourierStatus status, int trackingNumber, LocalDate deliveryDate) {
		super();
		this.senderName = senderName;
		SenderAddress = senderAddress;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.weight = weight;
		this.status = status;
		this.trackingNumber = trackingNumber;
		this.deliveryDate = deliveryDate;
	}
	
	public Courier(int id, String senderName, String receiverName, CourierStatus status) {
		super();
		this.id = id;
		this.senderName = senderName;
		this.receiverName = receiverName;
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderAddress() {
		return SenderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		SenderAddress = senderAddress;
	}
	public String getReceiverName() {
		return receiverName;
	}
	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}
	public String getReceiverAddress() {
		return receiverAddress;
	}
	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public CourierStatus getStatus() {
		return status;
	}
	public void setStatus(CourierStatus status) {
		this.status = status;
	}
	public int getTrackingNumber() {
		return trackingNumber;
	}
	public void setTrackingNumber(int trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	public LocalDate getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(LocalDate deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	@Override
	public String toString() {
		return "Courier [id=" + id + ", senderName=" + senderName + ", SenderAddress=" + SenderAddress
				+ ", receiverName=" + receiverName + ", receiverAddress=" + receiverAddress + ", weight=" + weight
				+ ", status=" + status + ", trackingNumber=" + trackingNumber + ", deliveryDate=" + deliveryDate + "]";
	}
	public Object toUpperCase() {
		// TODO Auto-generated method stub
		return null;
	}

}
