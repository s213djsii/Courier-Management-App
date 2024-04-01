package com.dto;

import java.util.Objects;

public class AssignedOrderDto {
	//c.courier_id,c.sender_name,c.sender_address,c.receiver_name,c.receiver_address,e.name
	private int courierId;
	private String senderName;
	private String senderAddress;
	private String receiverName;
	private String receiverAddress;
	private String employeeName;
	@Override
	public String toString() {
		return "AssignedOrderDto [courierId=" + courierId + ", senderName=" + senderName + ", senderAddress="
				+ senderAddress + ", receiverName=" + receiverName + ", receiverAddress=" + receiverAddress
				+ ", employeeName=" + employeeName + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(courierId, employeeName, receiverAddress, receiverName, senderAddress, senderName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AssignedOrderDto other = (AssignedOrderDto) obj;
		return courierId == other.courierId && Objects.equals(employeeName, other.employeeName)
				&& Objects.equals(receiverAddress, other.receiverAddress)
				&& Objects.equals(receiverName, other.receiverName)
				&& Objects.equals(senderAddress, other.senderAddress) && Objects.equals(senderName, other.senderName);
	}

	public int getCourierId() {
		return courierId;
	}
	public void setCourierId(int courierId) {
		this.courierId = courierId;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderAddress() {
		return senderAddress;
	}
	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
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
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public AssignedOrderDto(int courierId, String senderName, String senderAddress, String receiverName,
			String receiverAddress, String employeeName) {
		super();
		this.courierId = courierId;
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.receiverName = receiverName;
		this.receiverAddress = receiverAddress;
		this.employeeName = employeeName;
	}
	public AssignedOrderDto() {
		super();
		// TODO Auto-generated constructor stub
	}

}
