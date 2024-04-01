package com.dto;

import java.util.Objects;

import com.enums.CourierStatus;

public class CourierStatusDto {
	private int id;
	private CourierStatus status;
	public CourierStatusDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CourierStatusDto(int id, CourierStatus status) {
		super();
		this.id = id;
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, status);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CourierStatusDto other = (CourierStatusDto) obj;
		return id == other.id && status == other.status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public CourierStatus getStatus() {
		return status;
	}
	public void setStatus(CourierStatus status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "id=" + id + ", status=" + status;
	}
	

}
